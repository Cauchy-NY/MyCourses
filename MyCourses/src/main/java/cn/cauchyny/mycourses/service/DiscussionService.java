package cn.cauchyny.mycourses.service;

import cn.cauchyny.mycourses.dao.DiscussionDao;
import cn.cauchyny.mycourses.model.Discussion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussionService {
    @Autowired
    private DiscussionDao discussionDao;

    public List<Discussion> getPostList() {
        return discussionDao.selectByHasTitle();
    }

    public List<Discussion> getPostDetail(String id) {
        return discussionDao.selectById(id);
    }

    public void insertDiscussion(Discussion discussion) {
        discussionDao.insert(discussion);
    }
}
