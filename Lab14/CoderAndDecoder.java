import java.nio.charset.Charset;

public class CoderAndDecoder {
    String pKey;
    public byte[] encode(byte[] txt) {
        byte[] key = this.pKey.getBytes();
        byte[] res = new byte[txt.length];

        for (int i = 0; i < txt.length; i++) {
            res[i] = (byte) (txt[i] ^ key[i % key.length]);
        }
        return res;

    }
    public byte[] decode(byte[] pText) {
        byte[] res = new byte[pText.length];
        byte[] key = this.pKey.getBytes();

        for (int i = 0; i < pText.length; i++) {
            res[i] = (byte) (pText[i] ^ key[i % key.length]);
        }

        return res;
    }

    public CoderAndDecoder(String pKey) {
        this.pKey = pKey;
    }
}
