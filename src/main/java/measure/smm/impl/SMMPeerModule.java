package measure.smm.impl;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import measure.smm.api.ISMMPeerModule;
import org.modelio.api.module.IModuleAPIConfiguration;
import org.modelio.vbasic.version.Version;

@objid ("ef360a19-667f-4098-97f5-d4bd2753252a")
public class SMMPeerModule implements ISMMPeerModule {
    @objid ("e1cf9aa5-9b55-4d09-b353-e1e6aee17b58")
    private SMMModule module = null;

    @objid ("a09504fe-1031-45f7-830f-5a6a55712ba2")
    private IModuleAPIConfiguration peerConfiguration;

    @objid ("7e42caa9-8d1b-4d2e-a6ae-f5406e334aae")
    public SMMPeerModule(final SMMModule module, final IModuleAPIConfiguration peerConfiguration) {
        this.module = module;
        this.peerConfiguration = peerConfiguration;
    }

    @objid ("79c7a736-46ec-4839-82e8-ad9f4631b587")
    public IModuleAPIConfiguration getConfiguration() {
        return this.peerConfiguration;
    }

    @objid ("3b5ec53a-76b3-4d76-882d-444b96675e6e")
    public String getDescription() {
        return this.module.getDescription();
    }

    @objid ("4a169637-6ee2-4251-b91c-c82fd3c748ba")
    public String getName() {
        return this.module.getName();
    }

    @objid ("8d6fb8dc-fd6d-4690-a31b-0fe99d367bc2")
    public Version getVersion() {
        return this.module.getVersion();
    }

    @objid ("40da2f3d-2563-4aa9-8b5a-671b7370d645")
    void init() {
    }

}
