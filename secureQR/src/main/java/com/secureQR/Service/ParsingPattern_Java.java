package com.secureQR.Service;

/**
 * 싱글톤 패턴 적용하여, 서버 가동시 암호화 방식 / 암호화 데이터 파싱할 목적의 클래스로 설정했는데,
 * 스프링에서 적용방법 고민하다가 일단 보류
 */


class ParsingPattern_Java {
    private String ptrn;

    private ParsingPattern_Java(String _ptrn) {
        this.ptrn = _ptrn;
    }

    private static class ParsingPatternHolder{
        // 클래스 로딩 시점에서 생성
        public static final ParsingPattern_Java INSTANCE = new ParsingPattern_Java("index=\\d{1,2}&data=.+");
    }

    public static ParsingPattern_Java getInstance(){
        return ParsingPatternHolder.INSTANCE;
    }

    public String getPtrn(){
        return ptrn;
    }
}
