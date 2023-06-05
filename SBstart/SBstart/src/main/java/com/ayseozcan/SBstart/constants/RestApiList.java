package com.ayseozcan.SBstart.constants;

public class RestApiList {
    /**
     * projeler genellikle belli sunucular ve belli portlar uzerinde calisirlar.
     * buyuk projelerde ekipler ayrisir ve farkli ekipler farkli end pointler ile
     * istek atarlar. Bu ayrismayi daha kontrollu yapmak icin sabitleri yonetmek iyi fikirdir.
     */
    public static final String API = "/api";
    public static final String TEST = "/test";
    public static final String PROD = "/prod";

    public static final String VERSION = "/v1";
    public static final String PERSONEL = API + VERSION + "/personel";
    public static final String DEPARTMAN = API + VERSION + "/departman";
    public static final String PERSONELDEPARTMAN = API + VERSION + "/personeldepartman";
    public static final String SAVE = "/save";
    public static final String UPDATE = "/update";
    public static final String DELETE = "/delete";
    public static final String FINDALL = "/findall";


}
