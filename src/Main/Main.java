package Main;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.*;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.*;
import com.jme3.util.BufferUtils;
import java.io.File;
import java.net.URL;

public class Main extends SimpleApplication {

    public static void main(String[] args) {
        //settings.setTitle("SpectroScan3D Viewer");
        Main app = new Main();
        //app.setSettings(settings);
        app.start();
    }

    @Override
    public void simpleInitApp() {
        URL url = getClass().getResource("Frame0067");
        File f = new File(url.getPath());
        SPLFrame frame = new SPLFrame(f);
        Vector3f[] lineVerticies = frame.getCloud();
        plotPoints(lineVerticies, ColorRGBA.White);
    }


    public void plotPoints(Vector3f[] lineVerticies, ColorRGBA pointColor){
        Mesh mesh = new Mesh();
        mesh.setMode(Mesh.Mode.Points);

        mesh.setBuffer(VertexBuffer.Type.Position, 3, BufferUtils.createFloatBuffer(lineVerticies));

        mesh.updateBound();
        mesh.updateCounts();

        Geometry geo = new Geometry("line", mesh);
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", pointColor);
        geo.setMaterial(mat);

        rootNode.attachChild(geo);
    }


    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}