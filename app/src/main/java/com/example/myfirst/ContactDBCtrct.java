package com.example.myfirst;

public class ContactDBCtrct {
    private ContactDBCtrct () {};

    public static final String TBL_MYPAGE = "TBL_MYPAGE" ;
    public static final String NAME = "NAME" ;
    public static final String OLD = "OLD" ;
    public static final String TALL = "TALL";
    public static final String WEIGHT = "WEIGHT" ;

    //만약 CONTACT_T가 존재 하지 않는다면 만든다.
    // (NAME:text / OLD:INTEGER/ TALL:INTEGER/ WEIGHT:INTEGER)
    public static final String SQL_CREATE_TBL = "CREATE TABLE IF NOT EXISTS " + TBL_MYPAGE + " " +
            "(" +
            NAME +        " TEXT" +   ", " +
            OLD +      " INTEGER"             +   ", " +
            TALL +     " INTEGER"             +   ", " +
            WEIGHT +    " INTEGER"          +
            ")" ;
    // 만약 존재하는 CONTACT_T에서 테이블을 삭제할때
    public static final String SQL_DROP_TBL = "DROP TABLE IF EXISTS " + TBL_MYPAGE ;

    //SELECT * FROM CONTACT_T
    public static final String SQL_SELECT = "SELECT * FROM " + TBL_MYPAGE ;

    //삽입하거나 대신한다. CONTACT_T에 (이름, 나이, 키, 몸무게) VALUES (x,x,x,x)
    public static final String SQL_INSERT = "INSERT OR REPLACE INTO " + TBL_MYPAGE + " " +
            "(" + NAME + ", " + OLD + ", " + TALL + ", " + WEIGHT + ") VALUES " ;

    //CONTACT_T에서 DELETE
    public static final String SQL_DELETE = "DELETE FROM " +TBL_MYPAGE ;
}
