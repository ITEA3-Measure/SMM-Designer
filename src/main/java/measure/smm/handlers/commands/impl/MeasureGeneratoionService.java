package measure.smm.handlers.commands.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.uml.statik.Class;

@objid ("e9018350-4ce2-4851-845a-95cef83f9131")
public class MeasureGeneratoionService {
    @objid ("4c5b628e-c3b8-4b00-997a-f7aca889a3a9")
    private Class measure;

    @objid ("95d04b24-7c2e-41e0-b66f-8d2c1b696070")
    public MeasureGeneratoionService(Class measure) {
        this.measure = measure;
    }

    @objid ("aa4bf83a-6a37-458f-8e57-0cbbce8b7702")
    public void generateMeasure() {
        // Calculate Measure Path
        Path resourcePath = Modelio.getInstance().getModuleService().getPeerModule(ISMMPeerModule.class).getConfiguration().getModuleResourcesPath();
        Path measurePath = Modelio.getInstance().getContext().getProjectSpacePath().toPath().resolve("Measures").resolve(measure.getName().replace(" ", ""));
        
        // Create Directory Structure
        Path measureDir = null;
        Path javaDir = null;
        Path testDir = null;
        Path dataDir = null;
        try {
            measureDir = Files.createDirectories(measurePath);
            javaDir = Files.createDirectories(measureDir.resolve("src/main/java"));
            testDir = Files.createDirectories(measureDir.resolve("src/test/java"));
            dataDir = Files.createDirectories(measureDir.resolve("metadata"));
            Files.createDirectories(measureDir.resolve("lib"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Coppy Packager
        try {
            Files.copy(resourcePath.resolve("res/tool/mvnw.cmd"), measureDir.resolve("mvnw.cmd"));
            Files.createDirectories(measureDir.resolve(".mvn/wrapper/"));
            Files.copy(resourcePath.resolve("res/tool/maven-wrapper.properties"), measureDir.resolve(".mvn/wrapper/maven-wrapper.properties"));
            Files.copy(resourcePath.resolve("res/tool/maven-wrapper.jar"), measureDir.resolve(".mvn/wrapper/maven-wrapper.jar"));
        
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Generate POM
        geteratePOM(measure, measureDir);
        
        // Generate metadata file
        MetaDataGenerationService generator = new MetaDataGenerationService(measure);
        generator.generateMetadatas(dataDir.resolve("MeasureMetadata.xml"));
        
        // Generate Java
        JavaGenerationService proxy = new JavaGenerationService();
        proxy.generateJavaCode(measure, javaDir, testDir);
    }

    @objid ("1804bea7-7486-4d26-b33d-aeacf2e35477")
    private void geteratePOM(Class measure, Path measureDir) {
        Path file = measureDir.resolve("pom.xml");
        try {
            if(file.toFile().exists()){
                file.toFile().delete();
            }
            Files.createFile(file);
        
            try (BufferedWriter writer = Files.newBufferedWriter(file)) {
                writer.write("<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n");
                writer.write("        xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n");
                writer.write("        <modelVersion>4.0.0</modelVersion>\n");
                writer.write("        <groupId>org.measure.smmmeasure.impl</groupId>\n");
                writer.write("        <artifactId>" + measure.getName().replace(" ", "") + "</artifactId>\n");
                writer.write("        <version>1.0.0</version>\n");
                writer.write("\n");
                writer.write("        <repositories>\n");
                writer.write("            <repository>\n");
                writer.write("                <id>Modelio</id>\n");
                writer.write("                <url>http://repository.modelio.org/</url>\n");
                writer.write("            </repository>\n");
                
                for (Class sub : measure.getOwnedElement(Class.class)) {
                    if (sub.isStereotyped("SMM", "SmmImplementation")) {
                        String extention = sub.getNoteContent("SMM", "repository");
                        if (extention != null && !"".equals(extention)) {
                            writer.write("\n");
                            writer.write(extention + "\n");
                            writer.write("\n");
                        }
                    }
                }
                writer.write("        </repositories>\n");
                writer.write("\n");
                writer.write("        <dependencies>\n");
                writer.write("            <dependency>\n");
                writer.write("                <groupId>org.modelio</groupId>\n");
                writer.write("                <artifactId>javadesigner</artifactId>\n");
                writer.write("                <version>2.2.0</version>\n");
                writer.write("            </dependency>\n");
                writer.write("\n");
                writer.write("            <dependency>\n");
                writer.write("                <groupId>org.measure.smmmeasure.api</groupId>\n");
                writer.write("                <artifactId>SMMMeasureApi</artifactId>\n");
                writer.write("                <version>0.6.00</version>\n");
                writer.write("            </dependency>\n");
                writer.write("\n");
        
                for (Class sub : measure.getOwnedElement(Class.class)) {
                    if (sub.isStereotyped("SMM", "SmmImplementation")) {
                        String extention = sub.getNoteContent("SMM", "dependency");
                        if (extention != null && !"".equals(extention)) {
                            writer.write("\n");
                            writer.write(extention + "\n");
                            writer.write("\n");
                        }
                    }
                }
        
                writer.write("            <dependency>\n");
                writer.write("                <groupId>junit</groupId>\n");
                writer.write("                <artifactId>junit</artifactId>\n");
                writer.write("                <version>4.11</version>\n");
                writer.write("            </dependency>\n");
                writer.write("        </dependencies>\n");
                writer.write("\n");
                writer.write("        <build>\n");
                writer.write("                <plugins>\n");
                writer.write("                    <plugin>\n");
                writer.write("                        <groupId>org.apache.maven.plugins</groupId>\n");
                writer.write("                        <artifactId>maven-compiler-plugin</artifactId>\n");
                writer.write("                        <configuration>\n");
                writer.write("                            <source>1.8</source>\n");
                writer.write("                                <target>1.8</target>\n");
                writer.write("                                <encoding>UTF-8</encoding>\n");
                writer.write("                            </configuration>\n");
                writer.write("                            </plugin>\n");
        
                writer.write("<plugin>\n");
                writer.write("<groupId>org.apache.maven.plugins</groupId>\n");
                writer.write("<artifactId>maven-dependency-plugin</artifactId>\n");
                writer.write("<executions>\n");
                writer.write("    <execution>\n");
                writer.write("        <id>copy-deps</id>\n");
                writer.write("        <phase>package</phase>\n");
                writer.write("        <goals>\n");
                writer.write("            <goal>copy-dependencies</goal>\n");
                writer.write("        </goals>\n");
                writer.write("        <inherited>false</inherited>\n");
                writer.write("        <configuration>\n");
                writer.write("            <outputDirectory>${project.build.directory}/lib</outputDirectory>\n");
                writer.write("            <copyPom>false</copyPom>\n");
                writer.write("        </configuration>\n");
                writer.write("    </execution>\n");
                writer.write("</executions>\n");
                writer.write("</plugin>\n");
        
                writer.write("                    </plugins>\n");
                writer.write("            </build>\n");
                writer.write("            </project>\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
