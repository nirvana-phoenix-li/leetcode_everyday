package test.jttest;

public class T1 {
    public static void main(String[] args) {
        String original = "4845933777640323 igjhlflD8B8FVieCaxKzbx-XhNqy1SIP";
        String original_prod = "3098630502165122 2HiT0F_nwGotcMn1Adx6ufE9gxKBDVXK";

        // Encode
        String encoded = java.util.Base64.getEncoder().encodeToString(original.getBytes());
        System.out.println("Encoded: " + encoded);

        // Encode
        String encoded_prod = java.util.Base64.getEncoder().encodeToString(original_prod.getBytes());
        System.out.println("Encoded: " + encoded_prod);

        // Decode
        String decoded = new String(java.util.Base64.getDecoder().decode(encoded));
        System.out.println("Decoded: " + decoded);
    }
}
