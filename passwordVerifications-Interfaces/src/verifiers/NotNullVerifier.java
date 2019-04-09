package verifiers;

public class NotNullVerifier implements Verifier {

    @Override
    public boolean verify(String password) {
        return password != null;
    }
}
