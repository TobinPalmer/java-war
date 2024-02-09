package Graphics;

import Entities.Renderable;

import java.util.ArrayList;
import java.util.List;

public class Renderer {
    public static final int WIDTH = 150;
    public static final int HEIGHT = 50;

    private static final ArrayList<Renderable> frameOverlays = new ArrayList<>();

    public static void addToFrame(Renderable... overlay) {
        frameOverlays.addAll(List.of(overlay));
    }

    private static String[] getBlankFrame() {
        String[] frame = new String[HEIGHT];
        frame[0] = "-".repeat(WIDTH);
        for (int i = 1; i < HEIGHT - 1; i++) {
            frame[i] = STR."|\{" ".repeat(WIDTH - 2)}|";
        }
        frame[HEIGHT - 1] = "-".repeat(WIDTH);
        return frame;
    }

    public static void render() {
        String[] frame = getBlankFrame();

        for (Renderable overlay : frameOverlays) {
            String[] overlayLines = overlay.getOverlay();
            int y = HEIGHT - 1 - overlay.getPosition().y - (overlayLines.length / 2);
            int x = overlay.getPosition().x;
            for (int i = 0; i < overlayLines.length; i++) {
                String line = overlayLines[i];
                int start = Math.max(0, x);
                int end = Math.min(WIDTH, x + line.length());
                frame[y + i] = frame[y + i].substring(0, start) + line.substring(start - x, end - x) + frame[y + i].substring(end);
            }
        }

        for (String line : frame) {
            System.out.println(line);
        }

        frameOverlays.clear();
    }
}
