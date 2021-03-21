package io.namoosori.travelclub.spring;

import io.namoosori.travelclub.spring.aggregate.club.CommunityMember;
import io.namoosori.travelclub.spring.aggregate.club.TravelClub;
import io.namoosori.travelclub.spring.service.ClubService;
import io.namoosori.travelclub.spring.service.MemberService;
import io.namoosori.travelclub.spring.service.sdo.MemberCdo;
import io.namoosori.travelclub.spring.service.sdo.TravelClubCdo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.Date;

public class TravelClubApp {
    public  static  void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext( "applicationContext.xml");
        String [] beanNames = context.getBeanDefinitionNames();
        System.out.println(Arrays.toString(beanNames));
//
//        TravelClubCdo clubCdo = new TravelClubCdo("TreavelClub","ddddddddddddddd");
//        ClubService clubService = context.getBean("clubService", ClubService.class);
//        String clubId = clubService.registerClub(clubCdo);
//
//        TravelClub foundedClub = clubService.findClubById(clubId);
//        System.out.println("Club name " + foundedClub.getName());
//        System.out.println("Club intro " + foundedClub.getIntro());
//        System.out.println("Club foudationTime " + new Date(foundedClub.getFoundationTime()));

        MemberService memberService = context.getBean("memberServiceLogic",MemberService.class);

        String memberId = memberService.registerMember(
                new MemberCdo("test@test.com","kim","testmember","010-000-0000","2022.2.2")
        );

        CommunityMember foudedMember = memberService.findMemberById(memberId);
        System.out.println(foudedMember.toString());
    }
}
