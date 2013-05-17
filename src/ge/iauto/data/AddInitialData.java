package ge.iauto.data;

import ge.iauto.server.PersistenceService;

import java.util.ArrayList;
import java.util.List;

public class AddInitialData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
//		CarModel model = null;
//		List<CarModel> modelsss = new ArrayList<CarModel>();
//		
//		model = new CarModel();
//		model.setName("CL");
//		modelsss.add(model);
//		
//		model = new CarModel();
//		model.setName("CSX");
//		modelsss.add(model);
//		
//		model = new CarModel();
//		model.setName("El");
//		modelsss.add(model);
//		
//		model = new CarModel();
//		model.setName("ILX");
//		modelsss.add(model);
//		
//		model = new CarModel();
//		model.setName("Integra");
//		modelsss.add(model);
//		
//		model = new CarModel();
//		model.setName("Legend");
//		modelsss.add(model);
//		
//		model = new CarModel();
//		model.setName("MDX");
//		modelsss.add(model);
//		
//		model = new CarModel();
//		model.setName("NSX");
//		modelsss.add(model);
//		
//		model = new CarModel();
//		model.setName("RDX");
//		modelsss.add(model);
//		
//		model = new CarModel();
//		model.setName("TL");
//		modelsss.add(model);
//		
//		model = new CarModel();
//		model.setName("Verisa");
//		modelsss.add(model);
//		
//		model = new CarModel();
//		model.setName("ZDX");
//		modelsss.add(model);
//		
//		CarMake mark = new CarMake();
//		mark.setModels(modelsss);
//		mark.setName("ACURA");
		
		//===========================================
		
		CarModel mod = null;
		List<CarModel> models = new ArrayList<CarModel>();
		
		mod = new CarModel();
		mod.setName("145");
		models.add(mod);
		
//		mod = new CarModel();
//		mod.setName("146");
//		models.add(mod);
//		
//		mod = new CarModel();
//		mod.setName("156");
//		models.add(mod);
//		
//		mod = new CarModel();
//		mod.setName("159");
//		models.add(mod);
//		
//		mod = new CarModel();
//		mod.setName("164");
//		models.add(mod);
//		
//		mod = new CarModel();
//		mod.setName("8C");
//		models.add(mod);
//		
//		mod = new CarModel();
//		mod.setName("Alfasud");
//		models.add(mod);
//		
//		mod = new CarModel();
//		mod.setName("Alfeta");
//		models.add(mod);
//		
//		mod = new CarModel();
//		mod.setName("Arna");
//		models.add(mod);
//		
//		mod = new CarModel();
//		mod.setName("Brera");
//		models.add(mod);
//		
//		mod = new CarModel();
//		mod.setName("Giulieta");
//		models.add(mod);
//		
//		mod = new CarModel();
//		mod.setName("GT");
//		models.add(mod);
//		
//		mod = new CarModel();
//		mod.setName("GTA Coupe");
//		models.add(mod);
//		
//		mod = new CarModel();
//		mod.setName("GTV");
//		models.add(mod);
//		
//		mod = new CarModel();
//		mod.setName("Mito");
//		models.add(mod);
//		
//		mod = new CarModel();
//		mod.setName("Montreal");
//		models.add(mod);
//		
//		mod = new CarModel();
//		mod.setName("RZ");
//		models.add(mod);
//		
//		mod = new CarModel();
//		mod.setName("Spider");
//		models.add(mod);
//		
//		mod = new CarModel();
//		mod.setName("SZ");
//		models.add(mod);
		
		CarMake markk = new CarMake();
		markk.setModels(models);
		markk.setName("ALFA ROMEO");
		
		//==========================persist===================
		PersistenceService service = new PersistenceService();
	//	service.addCarMark(mark);
		service.addCarMark(markk);
		
		
		
	}

}
