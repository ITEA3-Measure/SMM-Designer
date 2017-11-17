package measure.smm.handlers.commands.impl;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.xml.bind.JAXBException;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.measure.smm.service.MeasurePackager;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.uml.statik.Class;
import org.modelio.module.javadesigner.dialog.DialogManager;

@objid ("67e0aa71-5f12-4496-963f-f6d1c32c5a1b")
public class MeasurePackagerService {
    @objid ("ad7e6653-daeb-4e9b-afeb-143cc927df74")
    private Class measure;

    @objid ("6ab4999a-6cd0-46e2-a33f-50d3b84b3104")
    public MeasurePackagerService(Class measure) {
        this.measure = measure;
    }

    @objid ("aa9de030-ed82-4082-8919-d90004805ed7")
    public boolean buildMeasure() {
        Path measurePath = Modelio.getInstance().getContext().getProjectSpacePath().toPath().resolve("Measures").resolve(measure.getName().replace(" ", "_"));
        
        Path target = measurePath.resolve("target/" + measure.getName().replace(" ", "_") + "-1.0.0.jar");
        if (target.toFile().exists()) {
            target.toFile().delete();
        }
        
        Runtime rt = Runtime.getRuntime();
        try {
            Path cmdPath = measurePath.resolve("mvnw.cmd");
            String command = cmdPath.toString() + " package";
            System.out.println("COMMAND : " + command);
            Process proc = rt.exec(command, null, measurePath.toFile());
        
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        
            BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
        
            // read the output from the command
            StringBuffer repport = new StringBuffer();
            String s = null;
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
                if (s != null)
                    repport.append(s);
            }
        
            // read any errors from the attempted command
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
        
            if (!target.toFile().exists()) {
                DialogManager.openError("Measure Packagine Error", repport.toString());
                return false;
            } else {
                // Coppy Library
                coppyLibrary(measurePath.resolve("target/lib"), measurePath.resolve("lib"));
                return true;
            }
        
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @objid ("50b5b31f-9746-48b3-876e-27f86f63d6c1")
    public void packageMeasure(Path targetPath,boolean logs) {
        Path measurePath = Modelio.getInstance().getContext().getProjectSpacePath().toPath().resolve("Measures").resolve(measure.getName().replace(" ", ""));
        Path target = measurePath.resolve("target/" + measure.getName() + "-1.0.0.jar");
        Path librarys = measurePath.resolve("lib");
            
        try {
            MetaDataGenerationService mdd = new MetaDataGenerationService(this.measure);
            try {
                MeasurePackager.packageMeasure(target, librarys, mdd.calculateMetadata(), targetPath);
                if(logs){
                    DialogManager.openInformation("Success", "The Measure has bean packaged to : " + targetPath.toString());
                    Desktop.getDesktop().open(targetPath.toFile().getParentFile());
                }
            } catch (JAXBException e) {
                DialogManager.openError("Measure Packagine Error", e.getMessage());
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @objid ("f9ec8b37-7405-49a7-a8ca-5a6b77df56db")
    private void coppyLibrary(Path source, Path target) {
        try {
            if (target.toFile().exists()) {
                removeDirectory(target.toFile());
                Files.createDirectories(target);
            }
        
            for (File lib : source.toFile().listFiles()) {
                if (!lib.getName().startsWith("SMMMeasureApi") && !lib.getName().startsWith("junit") && !lib.getName().startsWith("javadesigner") && !lib.getName().startsWith("jackson-databind") && !lib.getName().startsWith("jackson-core") && !lib.getName().startsWith("jackson-annotations") && !lib.getName().startsWith("hamcrest-core")) {
                    Files.copy(source.resolve(lib.getName()), target.resolve(lib.getName()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @objid ("b7d9fe57-e131-464b-bff6-d6fa95e8651c")
    public void removeDirectory(File dir) {
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null && files.length > 0) {
                for (File aFile : files) {
                    removeDirectory(aFile);
                }
            }
            dir.delete();
        } else {
            dir.delete();
        }
    }

}
