package verifiers;

public class LengthVerifier implements Verifier {
    @Override
    public boolean verify(String password) {
        return password.length() >= 8;
    }
}
