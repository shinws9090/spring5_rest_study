package spring5_rest_study.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sun.jndi.toolkit.url.Uri;

import spring5_rest_study.dto.Member;
import spring5_rest_study.exception.DuplicateMemberException;
import spring5_rest_study.service.GetMemberService;
import spring5_rest_study.service.MemberListService;
import spring5_rest_study.service.ModifyMemberService;
import spring5_rest_study.service.RegisterMemberService;
import spring5_rest_study.service.RemoveMemberService;

@RestController
@RequestMapping("/api")
public class RestMemberController {
	
	@Autowired
	private GetMemberService memService;
	@Autowired
	private MemberListService listService;
	@Autowired
	private ModifyMemberService modifyMemberService;
	@Autowired
	private RegisterMemberService registerMemberService;
	@Autowired
	private RemoveMemberService removeMemberService;
	
	
	@GetMapping("/members")
	public ResponseEntity<Object> members(){
		System.out.println("members()");
		System.out.println(listService.memberList());
		return ResponseEntity.ok(listService.memberList());
	}
	
	@GetMapping("/members/{id}")
	public ResponseEntity<Object> member(@PathVariable("id")Long id){
		Member member = memService.getMember(id);
		if(member==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(member);
	}
	
	@PostMapping("/members")
	public ResponseEntity<Object> newMember(@RequestBody Member member){
		System.out.println("newMember >>"+member);
		try {
			registerMemberService.registerMember(member);
			
			URI uri = URI.create("/api/members/"+member.getId());
			return ResponseEntity.created(uri).body(member.getId());
		}catch(DuplicateMemberException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	@PutMapping("/members/{id}")
	public ResponseEntity<Object> updateMember(@PathVariable("id")Long id, @RequestBody Member member){
		System.out.println("updateMember >>" + member);
		member.setId(id);
		return ResponseEntity.ok(modifyMemberService.modifyMember(member));
	}
	@DeleteMapping("/members/{id}")
	public ResponseEntity<Object> deleteMember(@PathVariable("id")Long id){
		System.out.println("deleteMember >>" + id);
		return ResponseEntity.ok(removeMemberService.removeMember(id));
	}

	
}
