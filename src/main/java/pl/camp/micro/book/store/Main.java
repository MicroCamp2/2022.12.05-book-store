package pl.camp.micro.book.store;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;

@Slf4j
public class Main {
    public static void main(String[] args) {
        log.debug(DigestUtils.md5Hex("janusz"));
    }
}
