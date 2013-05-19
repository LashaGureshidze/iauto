package ge.iauto.data;

import ge.iauto.server.PersistenceService;

import java.util.ArrayList;
import java.util.List;

public class AddInitialData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		CarModel model = null;
		List<CarModel> modelsss = new ArrayList<CarModel>();
		
		CarMake mark = new CarMake();
		mark.setName("ACURA");
		model = new CarModel();
		
		model.setName("CL");
		model.setCarmake(mark);
		modelsss.add(model);
		
		model = new CarModel();
		model.setName("CSX");
		model.setCarmake(mark);
		modelsss.add(model);
		
		model = new CarModel();
		model.setName("El");
		model.setCarmake(mark);
		modelsss.add(model);
		
		model = new CarModel();
		model.setName("ILX");
		model.setCarmake(mark);
		modelsss.add(model);
		
		model = new CarModel();
		model.setName("Integra");
		model.setCarmake(mark);
		modelsss.add(model);
		
		model = new CarModel();
		model.setName("Legend");
		model.setCarmake(mark);
		modelsss.add(model);
		
		model = new CarModel();
		model.setName("MDX");
		model.setCarmake(mark);
		modelsss.add(model);
		
		model = new CarModel();
		model.setName("NSX");
		model.setCarmake(mark);
		modelsss.add(model);
		
		model = new CarModel();
		model.setName("RDX");
		model.setCarmake(mark);
		modelsss.add(model);
		
		model = new CarModel();
		model.setName("TL");
		model.setCarmake(mark);
		modelsss.add(model);
		
		model = new CarModel();
		model.setName("Verisa");
		model.setCarmake(mark);
		modelsss.add(model);
		
		model = new CarModel();
		model.setName("ZDX");
		model.setCarmake(mark);
		modelsss.add(model);
		
		
		mark.setModels(modelsss);
		
		
		//===========================================
		
		CarModel mod = null;
		List<CarModel> models = new ArrayList<CarModel>();
		
		CarMake markk = new CarMake();
		markk.setName("ALFA ROMEO");
		
		mod = new CarModel();
		mod.setName("145");
		mod.setCarmake(markk);
		models.add(mod);
		
		mod = new CarModel();
		mod.setName("146");
		mod.setCarmake(markk);
		models.add(mod);
		
		mod = new CarModel();
		mod.setName("156");
		mod.setCarmake(markk);
		models.add(mod);
		
		mod = new CarModel();
		mod.setName("159");
		mod.setCarmake(markk);
		models.add(mod);
		
		mod = new CarModel();
		mod.setName("164");
		mod.setCarmake(markk);
		models.add(mod);
		
		mod = new CarModel();
		mod.setName("8C");
		mod.setCarmake(markk);
		models.add(mod);
		
		mod = new CarModel();
		mod.setName("Alfasud");
		mod.setCarmake(markk);
		models.add(mod);
		
		mod = new CarModel();
		mod.setName("Alfeta");
		mod.setCarmake(markk);
		models.add(mod);
		
		mod = new CarModel();
		mod.setName("Arna");
		mod.setCarmake(markk);
		models.add(mod);
		
		mod = new CarModel();
		mod.setName("Brera");
		mod.setCarmake(markk);
		models.add(mod);
		
		mod = new CarModel();
		mod.setName("Giulieta");
		mod.setCarmake(markk);
		models.add(mod);
		
		mod = new CarModel();
		mod.setName("GT");
		mod.setCarmake(markk);
		models.add(mod);
		
		mod = new CarModel();
		mod.setName("GTA Coupe");
		mod.setCarmake(markk);
		models.add(mod);
		
		mod = new CarModel();
		mod.setName("GTV");
		mod.setCarmake(markk);
		models.add(mod);
		
		mod = new CarModel();
		mod.setName("Mito");
		mod.setCarmake(markk);
		models.add(mod);
		
		mod = new CarModel();
		mod.setName("Montreal");
		mod.setCarmake(markk);
		models.add(mod);
		
		mod = new CarModel();
		mod.setName("RZ");
		mod.setCarmake(markk);
		models.add(mod);
		
		mod = new CarModel();
		mod.setName("Spider");
		mod.setCarmake(markk);
		models.add(mod);
		
		mod = new CarModel();
		mod.setName("SZ");
		mod.setCarmake(markk);
		models.add(mod);
		
		
		markk.setModels(models);
		
		
		//==========================persist===================
		PersistenceService service = new PersistenceService();
		service.saveCarMake(mark);
		service.saveCarMake(markk);
		
		
		
	}

}
