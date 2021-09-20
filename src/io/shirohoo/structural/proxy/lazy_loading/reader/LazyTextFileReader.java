package io.shirohoo.structural.proxy.lazy_loading.reader;

import static java.util.Objects.isNull;
import io.shirohoo.structural.proxy.cache.model.SecretText;
import io.shirohoo.structural.proxy.cache.reader.RealTextFileReader;
import io.shirohoo.structural.proxy.cache.reader.TextFileReader;
import io.shirohoo.structural.proxy.cache.util.SecretUtil;

public class LazyTextFileReader implements TextFileReader {

    private final String plainText;
    private TextFileReader reader;

    public LazyTextFileReader(final String encryptedText) {
        this.plainText = SecretUtil.decode(encryptedText);
    }

    @Override
    public SecretText read() {
        if (isNull(reader)) {
            reader = new RealTextFileReader(plainText);
        }
        System.out.println("lazy initialisation");
        return reader.read();
    }

}