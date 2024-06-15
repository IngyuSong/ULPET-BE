package com.overcomingroom.ulpet.response;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@ToString
public enum ResponseCode {
  // Member
  MEMBER_INFO_GET_SUCCESSFUL(HttpStatus.OK, "200", "멤버 정보 조회 성공"),

  // OAuth
  LOGIN_SUCCESSFUL(HttpStatus.OK, "200", "로그인 성공"),

  // TOUR API
  TOUR_API_CALL_SUCCESSFUL(HttpStatus.OK, "200" ,"tour api 호출 성공" );

  private final HttpStatus httpStatus;
  private final String code;
  private final String message;

  ResponseCode(HttpStatus httpStatus, String code, String message) {
    this.httpStatus = httpStatus;
    this.code = code;
    this.message = message;
  }

  public ResponseEntity<ResResult> toResponse(Object data) {
    return new ResponseEntity<>(ResResult.builder()
        .responseCode(this)
        .code(this.code)
        .message(this.message)
        .data(data)
        .build(), httpStatus.OK);
  }
}
