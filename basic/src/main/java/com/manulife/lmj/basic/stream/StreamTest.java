package com.manulife.lmj.basic.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
//        countFileType();
//        filterByType();
        mapAndFlatMap();
    }

    /*
     * In map we operate object
     * In flatMap we operate an stream, that means we can operate twice, such as combine a list
     * */
    private static void mapAndFlatMap() {
        generateData().stream().map(cases -> {
            cases.setName("name has changed");
            return cases;
        }).collect(Collectors.toList()).forEach(cases -> System.out.println(cases));
        System.out.println("----------");
        generateData().stream().flatMap(cases -> {
            return cases.getAttachments().stream();
        }).collect(Collectors.toList()).forEach(cases -> System.out.println(cases));

    }

    private static void filterByType() {
        generateData().stream().filter(cases -> {
            for (Attachments attachments : cases.getAttachments()) {
                if (attachments.getType().equals("doc")) {
                    return true;
                }
            }
            return false;
        }).collect(Collectors.toList()).stream().forEach(cases -> System.out.println(cases));

        System.out.println("----------");

        generateData().stream().filter(cases -> {
            return cases.getAttachments().stream().filter(attachments -> attachments.getType().equals("doc")).count() > 0;
        }).collect(Collectors.toList()).stream().forEach(cases -> System.out.println(cases));
    }

    /*
     * This requirement cased by Eric want to know the top 3 file types of the attachments.
     * But our database is Mongodb which support group by not friendly, so we are try to use Java stream to solve this issue
     * First, we need use map to find out all attachments list
     * Second, we need use reduce to merge all the attachments to an new ArrayList
     * Third, we use groupingBy to group by the file type
     * We can merge the first step and the second step to one step which will use reduce to combine the attachments to a list
     * */
    private static void countFileType() {
//        Map attachments = generateData().stream().map(cases -> {
//            return cases.getAttachments();
//        }).reduce(new ArrayList<>(), (newAttachmentsList, attachmentsList) -> {
//            newAttachmentsList.addAll(attachmentsList);
//            return newAttachmentsList;
//        }).stream().collect(Collectors.groupingBy(Attachments::getType, Collectors.counting()));

        Map attachments = generateData().stream().reduce(new Cases(new ArrayList<Attachments>()), (a, b) -> {
            a.getAttachments().addAll(b.getAttachments());
            return a;
        }).getAttachments().stream().collect(Collectors.groupingBy(Attachments::getType, Collectors.counting()));

        System.out.println(attachments);
    }

    private static List<Cases> generateData() {
        List<Cases> list = new ArrayList<>();
        Attachments a0 = new Attachments("Referral PDF", "pdf");
        Attachments a1 = new Attachments("Referral PNG", "png");
        Attachments a2 = new Attachments("Referral DOC", "doc");
        Attachments a3 = new Attachments("Referral PDF", "pdf");
        Attachments a4 = new Attachments("Referral DOC", "doc");
        Attachments a5 = new Attachments("Referral PDF", "pdf");
        Attachments a6 = new Attachments("Referral PDF", "pdf");
        Attachments a7 = new Attachments("Referral PDF", "pdf");
        Attachments a8 = new Attachments("Referral PDF", "pdf");
        Attachments a9 = new Attachments("Referral PDF", "pdf");
        List<Attachments> list1 = Arrays.asList(a0, a1, a2);
        List<Attachments> list2 = Arrays.asList(a3, a4, a5);
        List<Attachments> list3 = Arrays.asList(a6, a7, a8, a9);
        list.add(new Cases("1001", "1001", "Ring Liu", list1));
        list.add(new Cases("1002", "1002", "Ring Liu", list2));
        list.add(new Cases("1003", "1003", "Ring Liu", list3));
        return list;
    }

}
