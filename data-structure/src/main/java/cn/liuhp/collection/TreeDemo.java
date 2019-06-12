package cn.liuhp.collection;

import java.util.*;

/**
 * @description: 有关树结构的使用
 * @author: hz16092620
 * @create: 2019-05-31 09:15
 */
public class TreeDemo {

    //1.1、定义一个比较器comparator
    static Comparator<String> positiveComparator = new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {//s1 > s2 返回1是升序，s1 > s2 返回-1是降序
            String[] ss1 = s1.split("_");
            String[] ss2 = s2.split("_");
            if (Integer.valueOf(ss1[1]).intValue() > Integer.valueOf(ss2[1]).intValue()) {
                return 1;
            } else if (Integer.valueOf(ss1[1]).intValue() < Integer.valueOf(ss2[1]).intValue()) {
                return -1;
            } else {//如果相等，则比较前面那个数据
                if (Integer.valueOf(ss1[0]).intValue() > Integer.valueOf(ss2[0]).intValue()) {
                    return 1;
                } else if (Integer.valueOf(ss1[0]).intValue() < Integer.valueOf(ss2[0]).intValue()) {
                    return -1;
                } else {//相等的话就表示同一个数据，并且会更新数据，这里很重要啊
                    return 0;
                }
            }
        }
    };
    static Comparator<String> negativeComparator = new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {//s1 > s2 返回1是升序，s1 > s2 返回-1是降序
            String[] ss1 = s1.split("_");
            String[] ss2 = s2.split("_");
            if (Integer.valueOf(ss1[1]).intValue() > Integer.valueOf(ss2[1]).intValue()) {
                return -1;
            } else if (Integer.valueOf(ss1[1]).intValue() < Integer.valueOf(ss2[1]).intValue()) {
                return 1;
            } else {//如果相等，则比较前面那个数据
                if (Integer.valueOf(ss1[0]).intValue() > Integer.valueOf(ss2[0]).intValue()) {
                    return -1;
                } else if (Integer.valueOf(ss1[0]).intValue() < Integer.valueOf(ss2[0]).intValue()) {
                    return 1;
                } else {//相等的话就表示同一个数据，并且会更新数据，这里很重要啊
                    return 0;
                }
            }
        }
    };
    //1.2、定义一个比较器comparator  Comparator<? super K> comparator
    static Comparator<CharSequence> superComparator = new Comparator<CharSequence>() {
        @Override
        public int compare(CharSequence o1, CharSequence o2) {
            return 0;//代码省略
        }
    };

    public static void main(String[] args) {
        //testTreeMap();
        test1();
    }


    /*demo treeMap的自定义排序*/
    private static void testTreeMap() {
        //1、创建一个treeMap，没有穿comparator的默认是自然排序
        Map<String, String> treeMap = new TreeMap<>(negativeComparator);
        treeMap.put("1_3", "11");
        treeMap.put("2_1", "22");
        treeMap.put("3_2", "33");
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey());
        }
    }

    private static void test1() {
        //年-》次数->起始位置->唯一标识 2019033_10_117_198
        negativeComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] ss1 = s1.split("_");
                String[] ss2 = s2.split("_");
                Integer year1 = Integer.valueOf(ss1[0].substring(0, 4));
                Integer year2 = Integer.valueOf(ss2[0].substring(0, 4));
                if (year1.intValue() > year2.intValue()) {//年
                    return -1;
                } else if (year1.intValue() < year2.intValue()) {
                    return 1;
                } else {
                    if (Integer.valueOf(ss1[1]).intValue() > Integer.valueOf(ss2[1]).intValue()) {//次数
                        return -1;
                    } else if (Integer.valueOf(ss1[1]).intValue() < Integer.valueOf(ss2[1]).intValue()) {
                        return 1;
                    } else {
                        if (Integer.valueOf(ss1[0]).intValue() > Integer.valueOf(ss2[0]).intValue()) {//起始位置
                            return -1;
                        } else if (Integer.valueOf(ss1[0]).intValue() < Integer.valueOf(ss2[0]).intValue()) {
                            return 1;
                        } else {
                            if (Integer.valueOf(ss1[3]).intValue() > Integer.valueOf(ss2[3]).intValue()) {//唯一标识
                                return -1;
                            } else if (Integer.valueOf(ss1[3]).intValue() < Integer.valueOf(ss2[3]).intValue()) {
                                return 1;
                            } else {//相等的话就表示同一个数据，并且会更新数据，这里很重要啊
                                return 0;
                            }
                        }
                    }
                }

            }
        };
        Map<String, String> treeMap = new TreeMap<>(negativeComparator);
        init(treeMap);
        int year = 0;
        String startPeriod = "";
        String entPeriod = "";
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            startPeriod = entry.getKey().split("_")[0];
            entPeriod = Integer.valueOf(startPeriod) + Integer.valueOf(entry.getKey().split("_")[1]) - 1 + "";
            System.out.println(entry.getKey() + "=" + entry.getValue() + "=" + startPeriod + "-" + entPeriod);
        }
    }


    private static void init(Map<String, String> treeMap) {
        List<String> list = new ArrayList<>();
        list.add("2017091_15_337_468=正15_337");
        list.add("2017063_15_7_18=正15_7");
        list.add("2017098_13_300_425=反13_300");
        list.add("2017031_13_253_349=正13_253");
        list.add("2017115_13_253_348=反13_253");
        list.add("2017030_13_147_232=反13_147");
        list.add("2017150_13_146_228=反13_146");
        list.add("2017143_13_107_186=反13_107");
        list.add("2017062_13_48_114=正13_48");
        list.add("2017031_12_420_553=反12_420");
        list.add("2017097_12_373_493=正12_373");
        list.add("2017125_12_333_462=反12_333");
        list.add("2017117_12_288_401=反12_288");
        list.add("2017031_12_189_291=反12_189");
        list.add("2017031_12_169_267=反12_169");
        list.add("2017031_12_153_246=反12_153");
        list.add("2017031_12_148_235=反12_148");
        list.add("2017114_12_127_212=反12_127");
        list.add("2017063_12_49_116=正12_49");
        list.add("2017063_12_46_109=正12_46");
        list.add("2017063_12_43_98=正12_43");
        list.add("2017063_12_39_93=正12_39");
        list.add("2017063_12_34_83=正12_34");
        list.add("2017115_11_420_552=正11_420");
        list.add("2017117_11_358_487=反11_358");
        list.add("2017117_11_228_319=反11_228");
        list.add("2017117_11_221_313=反11_221");
        list.add("2017117_11_218_310=反11_218");
        list.add("2017117_11_189_290=正11_189");
        list.add("2017098_11_174_276=反11_174");
        list.add("2017146_11_142_222=反11_142");
        list.add("2017112_11_133_215=反11_133");
        list.add("2017142_11_125_209=反11_125");
        list.add("2017098_11_83_146=反11_83");
        list.add("2017115_11_71_135=反11_71");
        list.add("2017098_11_49_115=反11_49");
        list.add("2017098_11_46_108=反11_46");
        list.add("2017098_11_45_104=反11_45");
        list.add("2017147_11_31_78=反11_31");
        list.add("2017115_11_25_62=反11_25");
        list.add("2017115_11_18_45=反11_18");
        list.add("2017115_11_15_35=反11_15");
        list.add("2017018_11_4_12=正11_4");
        list.add("2017147_10_405_540=正10_405");
        list.add("2017061_10_377_503=反10_377");
        list.add("2017143_10_376_499=反10_376");
        list.add("2017049_10_339_471=反10_339");
        list.add("2017146_10_338_469=反10_338");
        list.add("2017146_10_335_465=正10_335");
        list.add("2017143_10_297_418=正10_297");
        list.add("2017147_10_268_365=反10_268");
        list.add("2017143_10_180_280=反10_180");
        list.add("2017028_10_154_248=反10_154");
        list.add("2017027_10_119_203=反10_119");
        list.add("2017143_10_115_195=反10_115");
        list.add("2017102_10_112_193=正10_112");
        list.add("2017104_10_108_188=正10_108");
        list.add("2017143_10_108_187=反10_108");
        list.add("2017146_10_92_163=反10_92");
        list.add("2017146_10_87_153=反10_87");
        list.add("2017050_10_85_150=反10_85");
        list.add("2017146_10_85_149=反10_85");
        list.add("2017105_10_52_118=正10_52");
        list.add("2017147_10_51_117=反10_51");
        list.add("2017147_10_36_87=反10_36");
        list.add("2017147_10_29_73=反10_29");
        list.add("2017017_10_19_49=正10_19");
        list.add("2017147_9_462_596=正9_462");
        list.add("2017147_9_460_595=正9_460");
        list.add("2017117_9_455_588=正9_455");
        list.add("2017147_9_455_587=正9_455");
        list.add("2017117_9_452_582=正9_452");
        list.add("2017117_9_445_575=正9_445");
        list.add("2017062_9_443_574=反9_443");
        list.add("2017147_9_440_571=正9_440");
        list.add("2017102_9_435_567=反9_435");
        list.add("2017055_9_416_544=反9_416");
        list.add("2017037_9_394_524=正9_394");
        list.add("2017114_9_394_523=反9_394");
        list.add("2017062_9_393_522=反9_393");
        list.add("2017117_9_385_510=正9_385");
        list.add("2017062_9_383_508=反9_383");
        list.add("2017086_9_379_504=正9_379");
        list.add("2017097_9_375_498=正9_375");
        list.add("2017062_9_374_497=反9_374");
        list.add("2017087_9_374_496=正9_374");
        list.add("2017097_9_374_495=正9_374");
        list.add("2017062_9_372_492=反9_372");
        list.add("2017097_9_372_491=正9_372");
        list.add("2017039_9_352_481=正9_352");
        list.add("2017028_9_350_479=反9_350");
        list.add("2017050_9_334_463=正9_334");
        list.add("2017102_9_330_458=反9_330");
        list.add("2017028_9_323_448=正9_323");
        list.add("2017117_9_315_439=正9_315");
        list.add("2017059_9_307_434=反9_307");
        list.add("2017124_9_294_412=反9_294");
        list.add("2017102_9_291_408=反9_291");
        list.add("2017102_9_288_402=反9_288");
        list.add("2017102_9_287_399=反9_287");
        list.add("2017114_9_279_385=正9_279");
        list.add("2017140_9_279_384=正9_279");
        list.add("2017141_9_274_376=正9_274");
        list.add("2017110_9_269_367=正9_269");
        list.add("2017044_9_246_336=反9_246");
        list.add("2017147_9_233_325=反9_233");
        list.add("2017097_9_232_324=正9_232");
        list.add("2017147_9_218_309=反9_218");
        list.add("2017147_9_213_304=反9_213");
        list.add("2017147_9_211_302=反9_211");
        list.add("2017147_9_209_300=正9_209");
        list.add("2017114_9_198_297=反9_198");
        list.add("2017073_9_187_288=反9_187");
        list.add("2017105_9_184_284=正9_184");
        list.add("2017105_9_183_283=正9_183");
        list.add("2017105_9_180_281=正9_180");
        list.add("2017105_9_177_278=正9_177");
        list.add("2017117_9_162_259=反9_162");
        list.add("2017054_9_144_225=反9_144");
        list.add("2017050_9_143_224=反9_143");
        list.add("2017105_9_143_223=正9_143");
        list.add("2017114_9_124_207=反9_124");
        list.add("2017114_9_121_205=反9_121");
        list.add("2017050_9_108_189=反9_108");
        list.add("2017097_9_106_185=正9_106");
        list.add("2017005_9_105_184=正9_105");
        list.add("2017028_9_104_182=反9_104");
        list.add("2017117_9_102_180=反9_102");
        list.add("2017117_9_95_169=反9_95");
        list.add("2017050_9_93_168=反9_93");
        list.add("2017117_9_92_164=反9_92");
        list.add("2017028_9_90_159=反9_90");
        list.add("2017028_9_88_156=反9_88");
        list.add("2017050_9_88_155=反9_88");
        list.add("2017117_9_46_107=反9_46");
        list.add("2017117_9_39_92=反9_39");
        list.add("2017117_9_36_88=反9_36");
        list.add("2017068_9_28_71=正9_28");
        list.add("2017068_9_27_69=正9_27");
        list.add("2017018_9_25_64=正9_25");
        list.add("2017068_9_25_63=正9_25");
        list.add("2017018_9_24_61=正9_24");
        list.add("2017018_9_23_59=正9_23");
        list.add("2017068_9_22_55=正9_22");
        list.add("2017068_9_18_46=正9_18");
        list.add("2017018_9_15_36=正9_15");
        list.add("2017147_9_15_34=反9_15");
        list.add("2017068_9_13_28=正9_13");
        list.add("2017018_9_10_24=正9_10");
        list.add("2017147_9_10_23=反9_10");
        list.add("2017147_9_8_20=反9_8");
        list.add("2017019_9_7_19=正9_7");
        list.add("2017117_9_7_17=反9_7");
        list.add("2017019_9_6_16=正9_6");
        list.add("2017019_9_5_14=正9_5");
        list.add("2017117_9_4_11=反9_4");
        list.add("2017147_9_4_10=反9_4");
        list.add("2017019_9_3_7=正9_3");
        list.add("2017019_9_2_6=正9_2");
        list.add("2017117_9_2_5=反9_2");
        list.add("2017147_9_2_4=反9_2");
        list.add("2017019_9_1_2=正9_1");
        list.add("2017147_9_1_1=反9_1");
        list.add("2017130_8_458_592=反8_458");
        list.add("2017063_8_457_591=反8_457");
        list.add("2017063_8_452_583=反8_452");
        list.add("2017063_8_448_580=反8_448");
        list.add("2017132_8_446_578=反8_446");
        list.add("2017063_8_445_576=反8_445");
        list.add("2017063_8_442_573=反8_442");
        list.add("2017098_8_441_572=反8_441");
        list.add("2017125_8_438_569=反8_438");
        list.add("2017076_8_434_566=正8_434");
        list.add("2017115_8_426_565=正8_426");
        list.add("2017115_8_423_560=正8_423");
        list.add("2017030_8_421_555=反8_421");
        list.add("2017115_8_414_542=正8_414");
        list.add("2017063_8_402_538=反8_402");
        list.add("2017150_8_401_536=正8_401");
        list.add("2017142_8_399_533=反8_399");
        list.add("2017063_8_398_532=反8_398");
        list.add("2017063_8_395_527=反8_395");
        list.add("2017063_8_392_519=反8_392");
        list.add("2017063_8_388_515=反8_388");
        list.add("2017063_8_385_511=反8_385");
        list.add("2017063_8_382_507=反8_382");
        list.add("2017087_8_381_506=正8_381");
        list.add("2017063_8_379_505=反8_379");
        list.add("2017087_8_377_502=正8_377");
        list.add("2017063_8_376_500=反8_376");
        list.add("2017063_8_373_494=反8_373");
        list.add("2017115_8_349_478=正8_349");
        list.add("2017138_8_346_474=正8_346");
        list.add("2017087_8_340_472=正8_340");
        list.add("2017098_8_336_467=反8_336");
        list.add("2017115_8_324_449=反8_324");
        list.add("2017064_8_301_429=正8_301");
        list.add("2017098_8_301_428=反8_301");
        list.add("2017064_8_300_426=正8_300");
        list.add("2017064_8_299_424=正8_299");
        list.add("2017098_8_299_423=反8_299");
        list.add("2017125_8_299_422=反8_299");
        list.add("2017098_8_298_421=反8_298");
        list.add("2017064_8_297_419=正8_297");
        list.add("2017064_8_296_417=正8_296");
        list.add("2017125_8_296_416=反8_296");
        list.add("2017064_8_294_413=正8_294");
        list.add("2017125_8_292_410=反8_292");
        list.add("2017064_8_291_409=正8_291");
        list.add("2017064_8_290_405=正8_290");
        list.add("2017064_8_288_403=正8_288");
        list.add("2017064_8_285_395=正8_285");
        list.add("2017064_8_281_392=正8_281");
        list.add("2017141_8_281_391=正8_281");
        list.add("2017013_8_280_389=反8_280");
        list.add("2017064_8_280_388=正8_280");
        list.add("2017064_8_278_382=正8_278");
        list.add("2017141_8_277_381=正8_277");
        list.add("2017064_8_275_378=正8_275");
        list.add("2017150_8_272_373=反8_272");
        list.add("2017064_8_271_371=正8_271");
        list.add("2017141_8_270_369=正8_270");
        list.add("2017134_8_263_362=正8_263");
        list.add("2017115_8_259_356=反8_259");
        list.add("2017055_8_257_354=正8_257");
        list.add("2017030_8_252_346=正8_252");
        list.add("2017115_8_250_342=反8_250");
        list.add("2017115_8_247_337=反8_247");
        list.add("2017135_8_241_332=正8_241");
        list.add("2017046_8_236_328=反8_236");
        list.add("2017087_8_235_327=正8_235");
        list.add("2017064_8_231_323=正8_231");
        list.add("2017064_8_230_322=正8_230");
        list.add("2017064_8_228_320=正8_228");
        list.add("2017064_8_225_316=正8_225");
        list.add("2017064_8_221_314=正8_221");
        list.add("2017064_8_216_307=正8_216");
        list.add("2017141_8_215_306=正8_215");
        list.add("2017139_8_214_305=正8_214");
        list.add("2017047_8_211_303=反8_211");
        list.add("2017098_8_210_301=反8_210");
        list.add("2017142_8_203_298=反8_203");
        list.add("2017030_8_190_293=反8_190");
        list.add("2017055_8_185_285=反8_185");
        list.add("2017133_8_179_279=反8_179");
        list.add("2017098_8_175_277=反8_175");
        list.add("2017098_8_173_273=反8_173");
        list.add("2017098_8_172_271=反8_172");
        list.add("2017030_8_170_269=反8_170");
        list.add("2017055_8_165_260=反8_165");
        list.add("2017055_8_155_250=反8_155");
        list.add("2017115_8_153_245=正8_153");
        list.add("2017030_8_149_237=反8_149");
        list.add("2017055_8_145_226=反8_145");
        list.add("2017004_8_140_220=正8_140");
        list.add("2017142_8_138_218=反8_138");
        list.add("2017142_8_129_214=反8_129");
        list.add("2017142_8_127_211=反8_127");
        list.add("2017104_8_119_202=正8_119");
        list.add("2017104_8_118_200=正8_118");
        list.add("2017104_8_115_196=正8_115");
        list.add("2017087_8_109_191=正8_109");
        list.add("2017125_8_109_190=正8_109");
        list.add("2017007_8_102_181=正8_102");
        list.add("2017104_8_88_154=正8_88");
        list.add("2017098_8_84_148=反8_84");
        list.add("2017098_8_82_145=反8_82");
        list.add("2017098_8_81_144=反8_81");
        list.add("2017115_8_77_139=反8_77");
        list.add("2017115_8_68_131=反8_68");
        list.add("2017115_8_65_127=反8_65");
        list.add("2017075_8_57_122=反8_57");
        list.add("2017150_8_55_120=反8_55");
        list.add("2017098_8_48_113=反8_48");
        list.add("2017098_8_47_111=反8_47");
        list.add("2017098_8_44_101=反8_44");
        list.add("2017150_8_40_95=反8_40");
        list.add("2017141_8_33_80=正8_33");
        list.add("2017150_8_30_76=反8_30");
        list.add("2017109_8_29_74=正8_29");
        list.add("2017019_8_28_72=正8_28");
        list.add("2017019_8_27_70=正8_27");
        list.add("2017003_8_26_67=正8_26");
        list.add("2017019_8_26_66=正8_26");
        list.add("2017019_8_22_56=正8_22");
        list.add("2017115_8_22_54=反8_22");
        list.add("2017019_8_21_53=正8_21");
        list.add("2017019_8_20_51=正8_20");
        list.add("2017115_8_19_48=反8_19");
        list.add("2017019_8_18_47=正8_18");
        list.add("2017019_8_17_42=正8_17");
        list.add("2017019_8_16_40=正8_16");
        list.add("2017019_8_14_32=正8_14");
        list.add("2017115_8_14_31=反8_14");
        list.add("2017019_8_13_29=正8_13");
        list.add("2017019_8_12_27=正8_12");
        list.add("2017019_8_11_26=正8_11");
        list.add("2017104_8_11_25=正8_11");
        list.add("2017019_8_9_22=正8_9");
        list.add("2017019_8_8_21=正8_8");
        System.out.println(list.size());
        for (String str : list) {
            treeMap.put(str.split("=")[0], str.split("=")[1]);
        }
    }
}
