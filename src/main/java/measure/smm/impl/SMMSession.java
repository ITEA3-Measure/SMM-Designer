package measure.smm.impl;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Map;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.api.modelio.Modelio;
import org.modelio.api.module.DefaultModuleSession;
import org.modelio.api.module.IPeerModule;
import org.modelio.api.module.ModuleException;
import org.modelio.vbasic.version.Version;

@objid ("68fc648e-d81a-4098-b379-b0f64ebe4366")
public class SMMSession extends DefaultModuleSession {
    @objid ("b169a7a5-5cd9-411e-a337-c1472c7430d9")
    public SMMSession(final SMMModule module) {
        super(module);
    }

    @objid ("c310a7b5-ce79-43c5-be96-e81ff8dc18f7")
    @Override
    public boolean start() throws ModuleException {
        Path source = this.module.getConfiguration().getModuleResourcesPath().resolve("res/generated/doctemplates/MeasureCatalogue.jar");
        Path target = Modelio.getInstance().getContext().getProjectSpacePath().toPath().resolve("data/templates/en/MeasureCatalogue.jar");
        
        try {
            Files.copy(source, target,StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.start();
    }

    @objid ("b3a47a11-885a-4880-8c53-acb4203c87d3")
    @Override
    public void stop() throws ModuleException {
        super.stop();
    }

    /**
     * @param mdaPath @return
     */
    @objid ("5c878fd8-4615-42eb-bb42-2547fa6cf25a")
    public static boolean install(final String modelioPath, final String mdaPath) throws ModuleException {
        return DefaultModuleSession.install(modelioPath, mdaPath);
    }

    @objid ("dbdc7148-9ac7-4c61-b045-ba765a58b97e")
    @Override
    public boolean select() throws ModuleException {
        return super.select();
    }

    @objid ("6e49e873-4a86-40f9-8d41-2e86aae78f75")
    @Override
    public void upgrade(final Version oldVersion, final Map<String, String> oldParameters) throws ModuleException {
        super.upgrade(oldVersion, oldParameters);
    }

    @objid ("57b826b9-229e-44a5-9272-d0699da8761c")
    @Override
    public void unselect() throws ModuleException {
        super.unselect();
    }

}
