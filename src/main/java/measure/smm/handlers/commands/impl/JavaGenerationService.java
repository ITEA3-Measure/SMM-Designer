package measure.smm.handlers.commands.impl;

import java.nio.file.Path;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.api.model.ITransaction;
import org.modelio.api.modelio.Modelio;
import org.modelio.metamodel.factory.ExtensionNotFoundException;
import org.modelio.metamodel.uml.statik.Class;
import org.modelio.metamodel.uml.statik.Component;
import org.modelio.module.javadesigner.impl.JavaDesignerPeerModule;

@objid ("c1afe8d7-48b2-4574-a37e-797e8ed9325d")
public class JavaGenerationService {
    @objid ("0e03167d-b1e7-44ce-a28a-79f363d30887")
    private JavaDesignerPeerModule javaPeer;

    @objid ("23c3416a-2d54-4bc5-a5cb-358eb363d542")
    public JavaGenerationService() {
        this.javaPeer = Modelio.getInstance().getModuleService().getPeerModule(JavaDesignerPeerModule.class);
    }

    @objid ("ccdc1e26-0064-4f54-8af8-af47a24b33e3")
    public boolean generateJavaCode(Class measure, Path javaDir, Path testDir) {
        if (javaPeer != null) {
            for (Class sub : measure.getOwnedElement(Class.class)) {
                if (sub.isStereotyped("SMM", "SmmImplementation")) {
                    for (Component javaComponent : sub.getOwnedElement(Component.class)) {
        
                        try(ITransaction tr = Modelio.getInstance().getModelingSession().createTransaction("JavaGeneration")) {
                            if (javaComponent.getName().endsWith("Test")) {
                                javaComponent.putTagValue("JavaDesigner", "GenerationPath", testDir.toString());
                            } else {
                                javaComponent.putTagValue("JavaDesigner", "GenerationPath", javaDir.toString());
                            }
                            tr.commit();
                        } catch (ExtensionNotFoundException e) {
                            e.printStackTrace();
                        }
         
                        javaPeer.generate(javaComponent,false);
                    }
                }
            }
        
            return true;
        }
        return false;
    }

    @objid ("b42bd850-0bdb-470b-8664-44c78e94f4fe")
    public boolean reversJavaCode(Class measure) {
        if (javaPeer != null) {
        
            return true;
        }
        return false;
    }

}
