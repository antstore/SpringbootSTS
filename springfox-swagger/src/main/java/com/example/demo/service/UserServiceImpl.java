package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repo.UserRepository;
import com.example.demo.repo.UserSpecification;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserSpecification userSpecification;

    @Value("${pagination.page.size.default}")
    private Integer defaultPageSize;

    @Override
    public UserResponseList getUserList(UserRequest request) {
        List<User> list = null;

        Page<User> pages = null;
        if (request.getPageNumber() == null) {
            pages = new PageImpl<>(userRepository.findAll(userSpecification.getUsers(request)));
        } else {
            if (request.getPageSize() == null) {
                request.setPageSize(defaultPageSize);
            }
            Pageable paging = PageRequest.of(request.getPageNumber() - 1, request.getPageSize());
            pages = userRepository.findAll(userSpecification.getUsers(request), paging);
        }
        if (pages != null && pages.getContent() != null) {
            list = pages.getContent();
            if (list != null && list.size() > 0) {
                UserResponseList respList = new UserResponseList();
                respList.setTotalPages(pages.getTotalPages());
                respList.setTotalCount(pages.getTotalElements());
                respList.setPageNo(pages.getNumber() + 1);
                respList.setUsers(new ArrayList<UserResponseDto>());
                for (User users : list) {
                    UserResponseDto obj = new UserResponseDto();
                    respList.getUsers().add(obj);
                }
                return respList;
            }
        }
        return null;
    }

}