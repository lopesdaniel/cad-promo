package com.danieldev.springajax.service;

import java.io.IOException;

import com.danieldev.springajax.domain.SocialMetaTag;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service
public class SocialMetaTagService {
    
    public SocialMetaTag getOpenGraphByURl(String url) {
        SocialMetaTag tag = new SocialMetaTag();
        try {
            Document doc = Jsoup.connect(url).get();
            tag.setTitle(doc.head().select("meta[property=og:title]").attr("content"));
            tag.setSite(doc.head().select("meta[property=og:site_name]").attr("content"));
            tag.setImage(doc.head().select("meta[property=og:image]").attr("content"));
            tag.setUrl(doc.head().select("meta[property=og:url]").attr("content"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tag;
    }

}
