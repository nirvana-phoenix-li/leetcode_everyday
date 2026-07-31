package test.jttest;

public class T1 {
    public static void main(String[] args) {
        String original = "4845933777640323 igjhlflD8B8FVieCaxKzbx-XhNqy1SIP";

        // Encode
        String encoded = java.util.Base64.getEncoder().encodeToString(original.getBytes());
        System.out.println("Encoded: " + encoded);

        // Decode
        String decoded = new String(java.util.Base64.getDecoder().decode(encoded));
        System.out.println("Decoded: " + decoded);
    }
}
