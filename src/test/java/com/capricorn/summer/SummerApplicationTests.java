package com.capricorn.summer;

import com.capricorn.summer.utils.BecomingRichUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SummerApplicationTests {

    public static void main(String[] args) {

        String req = BecomingRichUtil.req("003835","http://fundgz.1234567.com.cn/js/");
        System.out.println(BecomingRichUtil.regular(req));
    }

}
