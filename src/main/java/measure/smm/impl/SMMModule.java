package measure.smm.impl;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.api.model.IModelingSession;
import org.modelio.api.module.AbstractJavaModule;
import org.modelio.api.module.IModuleAPIConfiguration;
import org.modelio.api.module.IModuleSession;
import org.modelio.api.module.IModuleUserConfiguration;
import org.modelio.api.module.IParameterEditionModel;
import org.modelio.metamodel.mda.ModuleComponent;

@objid ("bf558cd1-2cb9-4f3a-8a30-1e8ef9de69ea")
public class SMMModule extends AbstractJavaModule {
    @objid ("58c8ae34-ec14-4261-bafc-c67942b114eb")
    private SMMPeerModule peerModule = null;

    @objid ("998dfaf5-811b-48fe-bd31-c80c8b9798e6")
    private SMMSession session = null;

    @objid ("340b820c-3cb1-47a4-ae85-b38afccfe410")
    public SMMModule(final IModelingSession modelingSession, final ModuleComponent moduleComponent, final IModuleUserConfiguration mdacConfiguration, final IModuleAPIConfiguration peerConfiguration) {
        super(modelingSession, moduleComponent, mdacConfiguration);
        this.session = new SMMSession(this);
        this.peerModule = new SMMPeerModule(this, peerConfiguration);
        init();
    }

    @objid ("71c63850-0ef4-462b-a9eb-ed2cc6705316")
    public SMMPeerModule getPeerModule() {
        return this.peerModule;
    }

    /**
     * Return the session attaced to the current module. This session is used to manage the module lifecycle by declaring the
     * desired implementation on start, select... methods.
     */
    @objid ("da58cd98-afaf-49b7-8036-66a07b03d05a")
    public IModuleSession getSession() {
        return this.session;
    }

    /**
     * Method automatically called just after the creation of the module. The module is automatically instanciated at the beginning
     * of the MDA lifecycle and constructor implementation is not accessible to the module developer. The <code>init</code> method
     * allows the developer to execute the desired initialization.
     */
    @objid ("aa47631d-9919-4153-8de4-6247661499fa")
    @Override
    public IParameterEditionModel getParametersEditionModel() {
        return super.getParametersEditionModel();
    }

    @objid ("e7a1738b-35f1-434f-9ea5-648577975e0d")
    @Override
    public String getModuleImagePath() {
        return "/res/icon/module.png";
    }

}
