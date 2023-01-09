package daily.question535;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @program: Leetcode
 * @description: TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk. Design a class to encode a URL and decode a tiny URL.
 * There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 * @author: Shen Zhengyu
 * @create: 2022-04-23 09:52
 **/
public class Codec {
    HashMap<Long, String> data;
    long increment; // unique

    public Codec() {
        data = new HashMap<>();
        increment = 1L;
    }

    private String getString(Long id) {
        String charMap = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        while (id > 0) {
            sb.append(charMap.charAt((int) (id % 62)));
            id /= 62L;
        }
        return sb.toString();
    }

    private Long getId(String shortUrl) {
        long id = 0; // initialize result
        char[] shortURL = shortUrl.toCharArray();
        // A simple base conversion logic
        for (int i = 0; i < shortUrl.length(); i++) {
            if ('a' <= shortURL[i] && shortURL[i] <= 'z')
                id = id * 62 + shortURL[i] - 'a';
            if ('A' <= shortURL[i] && shortURL[i] <= 'Z')
                id = id * 62 + shortURL[i] - 'A' + 26;
            if ('0' <= shortURL[i] && shortURL[i] <= '9')
                id = id * 62 + shortURL[i] - '0' + 52;
        }
        return id;
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrl = getString(increment);
        data.put(increment++, longUrl);
        return "http://tinyurl.com/" + shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String identifier = shortUrl.replace("http://tinyurl.com/", "");
        Long id = getId(identifier);
        return data.get(id);
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        System.out.println(codec.encode("www.google.com"));
        System.out.println(codec.decode(codec.encode("www.google.com")));
    }
}
/*
Solution obj = new Solution();
string tiny = obj.encode(url); // returns the encoded tiny url.
string ans = obj.decode(tiny); // returns the original url after deconding it.
 */