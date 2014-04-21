package me.inplex.inengine.mesh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.lwjgl.util.vector.Vector3f;

public class ObjLoader {

	public static Mesh load(String file){

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file))));
			
			Mesh mesh = new Mesh();
			
			while (reader.ready()){
				String line = reader.readLine();
				if (line.startsWith("v ")){
					Vector3f vector = new Vector3f();
					vector.x = Float.parseFloat(line.split(" ")[1]);
					vector.y = Float.parseFloat(line.split(" ")[2]);
					vector.z = Float.parseFloat(line.split(" ")[3]);
					mesh.addVertex(vector);
				} else if (line.startsWith("vn ")){			//for older files
					Vector3f vector = new Vector3f();
					vector.x = Float.parseFloat(line.split(" ")[1]);
					vector.y = Float.parseFloat(line.split(" ")[2]);
					vector.z = Float.parseFloat(line.split(" ")[3]);
					mesh.addVertex(vector);
				} else if (line.startsWith("f ")){
					Vector3f vector = new Vector3f();
					vector.x = Float.parseFloat(line.split(" ")[1]);
					vector.y = Float.parseFloat(line.split(" ")[2]);
					vector.z = Float.parseFloat(line.split(" ")[3]);
					mesh.addFace(vector);
				}
			}



			reader.close();
			return mesh;



		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}



	}

}


