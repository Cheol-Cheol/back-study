package com.group.libraryapp.domain.user.loanhistory;

import com.group.libraryapp.domain.user.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLoanHistoryRepsitory extends JpaRepository<UserRepository, Long> {
    // select * from user_loan_history where book_name = ? and is_return = ?
    boolean existsByBookNameAndIsReturn(String name, boolean isReturn);
}
