package me.inplex.inengine.mesh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

public class ObjLoader {

	public static Mesh load(String file){

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file))));

			Mesh mesh = new Mesh();
			List<Vector3f> vertices = new ArrayList<Vector3f>();
			List<Vector3f> normals  = new ArrayList<Vector3f>();

			while (reader.ready()){
				String line = reader.readLine();
				if (line.startsWith("v ")){
					Vector3f vector = new Vector3f();
					vector.x = Float.parseFloat(line.split(" ")[1]);
					vector.y = Float.parseFloat(line.split(" ")[2]);
					vector.z = Float.parseFloat(line.split(" ")[3]);
					vertices.add(vector);
				} else if (line.startsWith("vn ")){	
					Vector3f vector = new Vector3f();
					vector.x = Float.parseFloat(line.split(" ")[1]);
					vector.y = Float.parseFloat(line.split(" ")[2]);
					vector.z = Float.parseFloat(line.split(" ")[3]);
					normals.add(vector);
				} else if (line.startsWith("f ")){
					Face face = new Face();
					face.vectorSet(0,vertices.get((int)Float.parseFloat(line.split(" ")[1])-1));
					face.vectorSet(1,vertices.get((int)Float.parseFloat(line.split(" ")[2])-1));
					face.vectorSet(2,vertices.get((int)Float.parseFloat(line.split(" ")[3])-1));
					if (line.split(" ").length<3){
						face.vectorSet(3,null);
					}else{
						face.vectorSet(3,vertices.get((int)Float.parseFloat(line.split(" ")[4])-1));
					}
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


