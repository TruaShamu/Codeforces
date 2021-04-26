import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long width = sc.nextLong();
        long height = sc.nextLong();
        long tileSize = sc.nextLong();
        long area = (width * height) / (tileSize * tileSize);
        long tiles = tile(width, tileSize) * tile(height, tileSize);
        System.out.println(Long.max(area, tiles));
    }

    public static long tile(long length, long tileSize) {
        long tiles = length / tileSize;
        if (length % tileSize != 0) {
            tiles++;
        }
        return tiles;
    }
}
