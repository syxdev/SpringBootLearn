package com.song.springbootlearn.springboot.controller;

import com.song.springbootlearn.springboot.bean.AmazonProperties;
import com.song.springbootlearn.springboot.entity.Book;
import com.song.springbootlearn.springboot.entity.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/readingList")
//@ConfigurationProperties(prefix = "amazon")
public class ReadingListController {
    @Resource
    private ReadingListRepository readingListRepository;
    /*@Resource
    private String associateId;

    public void setAssociateId(String associateId) {
        this.associateId = associateId;
    }*/
    @Resource
    private AmazonProperties amazonProperties;
    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository,AmazonProperties amazonProperties) {
        this.readingListRepository = readingListRepository;
        this.amazonProperties=amazonProperties;
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readerBooks(@PathVariable("reader") String reader, Model model) {
        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
            model.addAttribute("reader",reader);
            model.addAttribute("amazonID",amazonProperties.getAssociateId());
        }
        return "readingList";
    }

    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader") String reader, Book book) {
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/readingList/{reader}";//这里重定向到上边那个方法的路径，即执行readerBooks方法
    }
}
