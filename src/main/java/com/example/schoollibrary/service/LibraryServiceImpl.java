package com.example.schoollibrary.service;

import com.example.schoollibrary.modelDTO.UserInfoDTO;
import com.example.schoollibrary.modelEntity.Usersbooks;
import com.example.schoollibrary.repository.UsersbooksRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class LibraryServiceImpl implements LibraryService {

    private final UsersbooksRepository usersbooksRepository;

    public LibraryServiceImpl(UsersbooksRepository usersbooksRepository) {
        this.usersbooksRepository = usersbooksRepository;
    }

    @Override
    public UserInfoDTO userStatisticInfo(Integer id) {
        log.info("IN LibraryServiceImpl  method userStatisticInfo {}", id);
        Usersbooks usersbooks = usersbooksRepository.getReferenceById(id);
        // UserInfoDTO usersbooks = usersbooksRepository.getReferenceById(id);

        UserInfoDTO userInfo = new UserInfoDTO();
        userInfo.setId(usersbooks.getUser().getId());
        userInfo.setFirstName(usersbooks.getUser().getFirstName());
        userInfo.setLastName(usersbooks.getUser().getLastName());
        userInfo.setBirthday(usersbooks.getUser().getBirthday());
        userInfo.setPhoneNumber(usersbooks.getUser().getPhoneNumber());
        userInfo.setEmail(usersbooks.getUser().getEmail());
        userInfo.setAdress(usersbooks.getUser().getAdress());
        userInfo.setCreatedAt(usersbooks.getUser().getCreatedAt());


        //Integer booksWasRead = Stream.of(usersbooks).forEach(u -> u.getDatePut() == null);
        //Stream<Usersbooks> booksWasRead = Stream.of(usersbooks);

        Long countBookWasRead = Stream.of(usersbooks).filter(c -> c.getDatePut() != null).count();
        Long countBookInProgress = Stream.of(usersbooks).filter(c -> c.getDatePut() == null).count();
        //Date maxDateGettingBook = Stream.of(usersbooks).filter(c -> c.getDateTake() != null).max(LocalDate::compareTo).get(); //orElse(null);

        Date maxDateGettingBook = Stream.of(usersbooks).filter(c -> c.getDateTake() != null)
                .map(Usersbooks::getDateTake)
                .max(Comparator.naturalOrder()).get();


        // int countBookWasRead = 0;
        // int countBookInProgress = 0;
//        for (Usersbooks ub : usersbooks) {
//            if(ub != null) {
//                countBookWasRead++;
//            }
//            if(ub.getDatePut() == null) {
//                countBookInProgress++;
//            }
//        }

        userInfo.setBookRead(countBookWasRead.intValue());          // stream(datePut -> datePut == null).count();
        userInfo.setBookInProgress(countBookInProgress.intValue());    // // stream(datePut -> datePut != null).count();
        userInfo.setLastDateTakedBookFromLibrary(maxDateGettingBook);
//
        //Stream<String> list = new ArrayList<>()
        //userInfo.setBookListInfo();     // stream == последняя дата взятия DICTINCT()- возвращаем все как LIST<BookDTO>

        return userInfo;
    }


}
