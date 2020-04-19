package challenge;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class CriptografiaCesariana implements Criptografia {

    final static int JULIO_CESAR_CRYPTO = 3;
    final static int ASCII_a = 97;
    final static int ASCII_z = 122;

    @Override
    public String criptografar(final String textToCrypto) {
        return this.executeCrypto(textToCrypto, JULIO_CESAR_CRYPTO);
    }

    @Override
    public String descriptografar(final String textToDecrypto) {
        return this.executeCrypto(textToDecrypto, (-1) * JULIO_CESAR_CRYPTO);
    }

    private String executeCrypto(final String text, final Integer number) {
        final StringBuilder textResult = new StringBuilder();

        if (text == null) {
            throw new NullPointerException("O texto não pode ser nulo.");
        } else if (text.isEmpty()) {
            throw new IllegalArgumentException("O texto não pode ser vazio");
        } else {
            final CharacterIterator it = new StringCharacterIterator(text.toLowerCase());

            while (it.current() != CharacterIterator.DONE) {
                char currentChar = it.current();

                if (currentChar >= ASCII_a && it.current() <= ASCII_z) {
                    currentChar += number;

                    currentChar = currentChar > ASCII_z ? (char) ((currentChar - ASCII_z) + (ASCII_a - 1)) : currentChar;
                    currentChar = currentChar < ASCII_a ? (char) ((ASCII_z + 1) - (ASCII_a - currentChar)) : currentChar;
                }
                
                textResult.append(currentChar);
                it.next();
            }

            return textResult.toString();
        }
    }
}
