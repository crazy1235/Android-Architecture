package com.jacksen.mvpdemo.bean;

/**
 * Created by Admin on 2016/4/21.
 */
public class WeatherInfo {

    /**
     * aqi : {"city":{"aqi":"253","pm25":"253","qlty":"重度污染"}}
     * basic : {"city":"北京","cnty":"中国","id":"CN101010100","lat":"39.904000","lon":"116.391000","update":{"loc":"2016-04-21 11:49","utc":"2016-04-21 03:49"}}
     * now : {"cond":{"code":"100","txt":"晴"},"fl":"24","hum":"32","pcpn":"0","pres":"1002","tmp":"24","vis":"4","wind":{"deg":"200","dir":"西南风","sc":"4-5","spd":"21"}}
     * status : ok
     * suggestion : {"comf":{"brf":"较舒适","txt":"白天天气晴好，您在这种天气条件下，会感觉早晚凉爽、舒适，午后偏热。"},"cw":{"brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"},"drsg":{"brf":"热","txt":"天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"},"flu":{"brf":"少发","txt":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"},"sport":{"brf":"较适宜","txt":"天气较好，但风力较大，推荐您进行室内运动，若在户外运动请注意避风保暖。"},"trav":{"brf":"适宜","txt":"天气较好，是个好天气哦。稍热但是风大，能缓解炎热的感觉，适宜旅游，可不要错过机会呦！"},"uv":{"brf":"很强","txt":"紫外线辐射极强，建议涂擦SPF20以上、PA++的防晒护肤品，尽量避免暴露于日光下。"}}
     */

    /**
     * city : {"aqi":"253","pm25":"253","qlty":"重度污染"}
     */

    private AqiEntity aqi;
    /**
     * city : 北京
     * cnty : 中国
     * id : CN101010100
     * lat : 39.904000
     * lon : 116.391000
     * update : {"loc":"2016-04-21 11:49","utc":"2016-04-21 03:49"}
     */

    private BasicEntity basic;
    /**
     * cond : {"code":"100","txt":"晴"}
     * fl : 24
     * hum : 32
     * pcpn : 0
     * pres : 1002
     * tmp : 24
     * vis : 4
     * wind : {"deg":"200","dir":"西南风","sc":"4-5","spd":"21"}
     */

    private NowEntity now;
    private String status;
    /**
     * comf : {"brf":"较舒适","txt":"白天天气晴好，您在这种天气条件下，会感觉早晚凉爽、舒适，午后偏热。"}
     * cw : {"brf":"较适宜","txt":"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。"}
     * drsg : {"brf":"热","txt":"天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"}
     * flu : {"brf":"少发","txt":"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。"}
     * sport : {"brf":"较适宜","txt":"天气较好，但风力较大，推荐您进行室内运动，若在户外运动请注意避风保暖。"}
     * trav : {"brf":"适宜","txt":"天气较好，是个好天气哦。稍热但是风大，能缓解炎热的感觉，适宜旅游，可不要错过机会呦！"}
     * uv : {"brf":"很强","txt":"紫外线辐射极强，建议涂擦SPF20以上、PA++的防晒护肤品，尽量避免暴露于日光下。"}
     */

    private SuggestionEntity suggestion;

    public AqiEntity getAqi() {
        return aqi;
    }

    public void setAqi(AqiEntity aqi) {
        this.aqi = aqi;
    }

    public BasicEntity getBasic() {
        return basic;
    }

    public void setBasic(BasicEntity basic) {
        this.basic = basic;
    }

    public NowEntity getNow() {
        return now;
    }

    public void setNow(NowEntity now) {
        this.now = now;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SuggestionEntity getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(SuggestionEntity suggestion) {
        this.suggestion = suggestion;
    }

    public static class AqiEntity {
        /**
         * aqi : 253
         * pm25 : 253
         * qlty : 重度污染
         */

        private CityEntity city;

        public CityEntity getCity() {
            return city;
        }

        public void setCity(CityEntity city) {
            this.city = city;
        }

        public static class CityEntity {
            private String aqi;
            private String pm25;
            private String qlty;

            public String getAqi() {
                return aqi;
            }

            public void setAqi(String aqi) {
                this.aqi = aqi;
            }

            public String getPm25() {
                return pm25;
            }

            public void setPm25(String pm25) {
                this.pm25 = pm25;
            }

            public String getQlty() {
                return qlty;
            }

            public void setQlty(String qlty) {
                this.qlty = qlty;
            }
        }
    }

    public static class BasicEntity {
        private String city;
        private String cnty;
        private String id;
        private String lat;
        private String lon;
        /**
         * loc : 2016-04-21 11:49
         * utc : 2016-04-21 03:49
         */

        private UpdateEntity update;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCnty() {
            return cnty;
        }

        public void setCnty(String cnty) {
            this.cnty = cnty;
        }

        public String getId() {
            return id;
        }


        public void setId(String id) {
            this.id = id;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLon() {
            return lon;
        }

        public void setLon(String lon) {
            this.lon = lon;
        }

        public UpdateEntity getUpdate() {
            return update;
        }

        public void setUpdate(UpdateEntity update) {
            this.update = update;
        }

        public static class UpdateEntity {
            private String loc;
            private String utc;

            public String getLoc() {
                return loc;
            }

            public void setLoc(String loc) {
                this.loc = loc;
            }

            public String getUtc() {
                return utc;
            }

            public void setUtc(String utc) {
                this.utc = utc;
            }
        }
    }

    public static class NowEntity {
        /**
         * code : 100
         * txt : 晴
         */

        private CondEntity cond;
        private String fl;
        private String hum;
        private String pcpn;
        private String pres;
        private String tmp;
        private String vis;
        /**
         * deg : 200
         * dir : 西南风
         * sc : 4-5
         * spd : 21
         */

        private WindEntity wind;

        public CondEntity getCond() {
            return cond;
        }

        public void setCond(CondEntity cond) {
            this.cond = cond;
        }

        public String getFl() {
            return fl;
        }

        public void setFl(String fl) {
            this.fl = fl;
        }

        public String getHum() {
            return hum;
        }

        public void setHum(String hum) {
            this.hum = hum;
        }

        public String getPcpn() {
            return pcpn;
        }

        public void setPcpn(String pcpn) {
            this.pcpn = pcpn;
        }

        public String getPres() {
            return pres;
        }

        public void setPres(String pres) {
            this.pres = pres;
        }

        public String getTmp() {
            return tmp;
        }

        public void setTmp(String tmp) {
            this.tmp = tmp;
        }

        public String getVis() {
            return vis;
        }

        public void setVis(String vis) {
            this.vis = vis;
        }

        public WindEntity getWind() {
            return wind;
        }

        public void setWind(WindEntity wind) {
            this.wind = wind;
        }

        public static class CondEntity {
            private String code;
            private String txt;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class WindEntity {
            private String deg;
            private String dir;
            private String sc;
            private String spd;

            public String getDeg() {
                return deg;
            }

            public void setDeg(String deg) {
                this.deg = deg;
            }

            public String getDir() {
                return dir;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public String getSc() {
                return sc;
            }

            public void setSc(String sc) {
                this.sc = sc;
            }

            public String getSpd() {
                return spd;
            }

            public void setSpd(String spd) {
                this.spd = spd;
            }
        }
    }

    public static class SuggestionEntity {
        /**
         * brf : 较舒适
         * txt : 白天天气晴好，您在这种天气条件下，会感觉早晚凉爽、舒适，午后偏热。
         */

        private ComfEntity comf;
        /**
         * brf : 较适宜
         * txt : 较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。
         */

        private CwEntity cw;
        /**
         * brf : 热
         * txt : 天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。
         */

        private DrsgEntity drsg;
        /**
         * brf : 少发
         * txt : 各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。
         */

        private FluEntity flu;
        /**
         * brf : 较适宜
         * txt : 天气较好，但风力较大，推荐您进行室内运动，若在户外运动请注意避风保暖。
         */

        private SportEntity sport;
        /**
         * brf : 适宜
         * txt : 天气较好，是个好天气哦。稍热但是风大，能缓解炎热的感觉，适宜旅游，可不要错过机会呦！
         */

        private TravEntity trav;
        /**
         * brf : 很强
         * txt : 紫外线辐射极强，建议涂擦SPF20以上、PA++的防晒护肤品，尽量避免暴露于日光下。
         */

        private UvEntity uv;

        public ComfEntity getComf() {
            return comf;
        }

        public void setComf(ComfEntity comf) {
            this.comf = comf;
        }

        public CwEntity getCw() {
            return cw;
        }

        public void setCw(CwEntity cw) {
            this.cw = cw;
        }

        public DrsgEntity getDrsg() {
            return drsg;
        }

        public void setDrsg(DrsgEntity drsg) {
            this.drsg = drsg;
        }

        public FluEntity getFlu() {
            return flu;
        }

        public void setFlu(FluEntity flu) {
            this.flu = flu;
        }

        public SportEntity getSport() {
            return sport;
        }

        public void setSport(SportEntity sport) {
            this.sport = sport;
        }

        public TravEntity getTrav() {
            return trav;
        }

        public void setTrav(TravEntity trav) {
            this.trav = trav;
        }

        public UvEntity getUv() {
            return uv;
        }

        public void setUv(UvEntity uv) {
            this.uv = uv;
        }

        public static class ComfEntity {
            private String brf;
            private String txt;

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class CwEntity {
            private String brf;
            private String txt;

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class DrsgEntity {
            private String brf;
            private String txt;

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class FluEntity {
            private String brf;
            private String txt;

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class SportEntity {
            private String brf;
            private String txt;

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class TravEntity {
            private String brf;
            private String txt;

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }

        public static class UvEntity {
            private String brf;
            private String txt;

            public String getBrf() {
                return brf;
            }

            public void setBrf(String brf) {
                this.brf = brf;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }
        }
    }
}
