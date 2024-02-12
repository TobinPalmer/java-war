package Graphics;

import Entities.Renderable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Renderer {
    public static final int FPS = 120;
    public static final int WIDTH;
    public static final int HEIGHT = 50;
    private static final ArrayList<Renderable> frameOverlays = new ArrayList<>();

    static {
        try {
            WIDTH = execCmd("tput cols 2> /dev/tty").isEmpty() ? 150 : Integer.parseInt(execCmd("tput cols 2> /dev/tty").trim()) - 2;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

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
            int overlayWidth = overlayLines[0].length();
            int x = overlay.getPosition().x - overlayWidth / 2;
            for (int i = 0; i < overlayLines.length; i++) {
                String line = overlayLines[i];
                int start = Math.max(0, x);
                int end = Math.min(WIDTH, x + line.length());
                frame[y + i] = frame[y + i].substring(0, start) + line.substring(start - x, end - x) + frame[y + i].substring(end);
            }
        }

        clearScreen();

        System.out.println(String.join("\n", frame));

        frameOverlays.clear();
    }

    public static String execCmd(String cmd) throws java.io.IOException {
        // Run a command and get the output with ProcessBuilder
        var processBuilder = new ProcessBuilder("bash", "-c", cmd);
        var process = processBuilder.start();
        var output = new StringBuilder();
        var reader = new java.io.BufferedReader(new java.io.InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }

        return output.toString();
    }

    public static void waitForNextFrame() {
        try {
            Thread.sleep(1000 / FPS);
        } catch (InterruptedException e) {
            System.out.println(STR."Interrupted \{e}");
        }
    }
}
