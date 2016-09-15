package org.laidu.bookStore.serviceImpl;

import org.laidu.bookStore.mapper.BookMapper;
import org.laidu.bookStore.model.BookModel;
import org.laidu.bookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by laidu on 16-9-13.
 */
@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookMapper bookMapper;

    @Override
    public int addBook(BookModel bookModel) {
        return bookMapper.insert(bookModel);
    }

    @Override
    public int delBook(int id) {
        return bookMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<BookModel> findList() {
        return bookMapper.findList();
    }

    @Override
    public BookModel findDetial(int id) {
        return (BookModel) bookMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updataBook(BookModel bookModel) {
        return bookMapper.updateByPrimaryKeySelective(bookModel);
    }
}
