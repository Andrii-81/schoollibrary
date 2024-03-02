package com.example.schoollibrary.service;

import com.example.schoollibrary.modelDTO.UserInfoDTO;
import com.example.schoollibrary.modelEntity.Usersbooks;
import com.example.schoollibrary.repository.UsersbooksRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
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


        Long countBookWasRead = Stream.of(usersbooks).filter(c -> c.getDatePut() != null).count();
        Long countBookInProgress = Stream.of(usersbooks).filter(c -> c.getDatePut() == null).count();
        Date maxDateGettingBook = Stream.of(usersbooks).filter(c -> c.getDateTake() != null)
                .map(Usersbooks::getDateTake)
                .max(Comparator.naturalOrder()).get();


        int countBookWasRead_1 = 0;
        int countBookInProgress_1 = 0;
        //Date maxDate = new Date(1990, 01, 01);
        Date maxDate = new Date();

        for (Usersbooks ub : usersbooks.getUser().getUsersbooks()) {
            if(ub.getDateTake() != null) {
                countBookWasRead_1++;
            }
            if(ub.getDateTake() != null && ub.getDatePut() == null) {
                countBookInProgress_1++;
            }
            if(ub.getDateTake().getTime() > maxDate.getTime()) {

                //maxDate = ub.getDateTake();
                //maxDate = new Date(ub.getDateTake().getTime());
                // maxDate = new Date(ub.getDateTake().getYear(), ub.getDateTake().getMonth(), ub.getDateTake().getDay());
                maxDate = new Date();
                maxDate.setTime(ub.getDateTake().getTime());
            }
        }
        userInfo.setBookRead(countBookWasRead_1);          // stream(datePut -> datePut == null).count();
        userInfo.setBookInProgress(countBookInProgress_1);    // // stream(datePut -> datePut != null).count();
        userInfo.setLastDateTakedBookFromLibrary(maxDate);

        //userInfo.setBookRead(countBookWasRead.intValue());          // stream(datePut -> datePut == null).count();
        //userInfo.setBookInProgress(countBookInProgress.intValue());    // // stream(datePut -> datePut != null).count();
        //userInfo.setLastDateTakedBookFromLibrary(maxDateGettingBook);


        return userInfo;
    }


}
