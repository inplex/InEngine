package me.inplex.inengine.mesh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.util.vector.Vector3f;

public class ObjLoader {

	public static Mesh load(String file) {

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(file))));

			Mesh mesh = new Mesh();

			// temporary
			List<Vector3f> vertices = new ArrayList<Vector3f>();
			List<Vector3f> normals = new ArrayList<Vector3f>();

			// given to the mesh object
			List<Face> faces = new ArrayList<Face>();

			while (reader.ready()) {
				String line = reader.readLine();
				if (line.startsWith("v ")) {
					Vector3f vector = new Vector3f();
					vector.x = Float.parseFloat(line.split(" ")[1]);
					vector.y = Float.parseFloat(line.split(" ")[2]);
					vector.z = Float.parseFloat(line.split(" ")[3]);
					vertices.add(vector);
				} else if (line.startsWith("vn ")) {
					Vector3f vector = new Vector3f();
					vector.x = Float.parseFloat(line.split(" ")[1]);
					vector.y = Float.parseFloat(line.split(" ")[2]);
					vector.z = Float.parseFloat(line.split(" ")[3]);
					normals.add(vector);
				} else if (line.startsWith("f ")) {
					Face face = new Face();
					Vector3f[] faceVertices = new Vector3f[4];
					// 4th fector is null if Face is an edge
					// id -1 because vertex ids start at 1, not at 0
					faceVertices[0] = vertices.get(Integer.parseInt(line.split(" ")[1]) - 1);
					faceVertices[1] = vertices.get(Integer.parseInt(line.split(" ")[2]) - 1);
					faceVertices[2] = vertices.get(Integer.parseInt(line.split(" ")[3]) - 1);
					// if line.split(" ").length >= 5 then it face is a surface,
					// otherwise an edge
					if (line.split(" ").length >= 5) {
						faceVertices[3] = vertices.get(Integer.parseInt(line.split(" ")[4]) - 1);
					}
					face.setVertices(faceVertices);
					faces.add(face);
				}
			}
			reader.close();
			mesh.setFaces(faces);
			return mesh;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

}
