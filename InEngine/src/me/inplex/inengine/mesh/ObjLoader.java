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

			List<Vector3f> vertices = new ArrayList<Vector3f>();
			List<Vector3f> normals = new ArrayList<Vector3f>();
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
					if (line.contains("//")) {
						Face face = new Face();
						int[] faceVertexIds = new int[4];
						int[] faceNormalIds = new int[3];
						faceVertexIds[0] = Integer.parseInt(line.split(" ")[1].split("//")[0]);
						faceVertexIds[1] = Integer.parseInt(line.split(" ")[2].split("//")[0]);
						faceVertexIds[2] = Integer.parseInt(line.split(" ")[3].split("//")[0]);

						faceNormalIds[0] = Integer.parseInt(line.split(" ")[1].split("//")[1]);
						faceNormalIds[1] = Integer.parseInt(line.split(" ")[2].split("//")[1]);
						faceNormalIds[2] = Integer.parseInt(line.split(" ")[3].split("//")[1]);
						face.setVertexIds(faceVertexIds);
						face.setNormalIds(faceNormalIds);
						faces.add(face);
					} else {
						Face face = new Face();
						int[] faceVertices = new int[4];
						// 4th fector is null if Face is an edge
						// id -1 because vertex ids start at 1, not at 0
						faceVertices[0] = Integer.parseInt(line.split(" ")[1]);
						faceVertices[1] = Integer.parseInt(line.split(" ")[2]);
						faceVertices[2] = Integer.parseInt(line.split(" ")[3]);
						// if line.split(" ").length >= 5 then it face is a
						// surface,
						// otherwise an edge
						if (line.split(" ").length >= 5) {
							faceVertices[3] = Integer.parseInt(line.split(" ")[4]);
						}
						face.setVertexIds(faceVertices);
						faces.add(face);
					}
				}
			}
			reader.close();
			mesh.setVertices(vertices);
			mesh.setNormals(normals);
			mesh.setFaces(faces);
			return mesh;

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

}
