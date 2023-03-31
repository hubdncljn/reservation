package com.myweb.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myweb.domain.MemResVO;
import com.myweb.domain.MemVO;
import com.myweb.domain.PageMakerDTO;
import com.myweb.domain.PageVO;
import com.myweb.domain.ResVO;
import com.myweb.service.MemService;
import com.myweb.service.ResService;

@Controller
@RequestMapping("/res/*")
public class ResController {
	private static final Logger logger = LoggerFactory.getLogger(ResController.class);
	
	@Autowired
	private ResService resService;
	
	@Autowired 
	private MemService memService;
	
	/* 예약 목록 페이지 이동 */
	@GetMapping("/list")
	public void resListPage(Model model, PageVO pgvo) {
		model.addAttribute("list", resService.getListPaging(pgvo));
		
		int total = resService.totalCount();
		PageMakerDTO pageMaker = new PageMakerDTO(pgvo, total);
		model.addAttribute("totalCount" , total);
		model.addAttribute("pageMaker", pageMaker);
		logger.info("예약 목록 페이지");
		
	}
	
	/* 예약 등록 페이지 이동 */
	@GetMapping("/regist")
	public void resRegistPage() {
		logger.info("예약 등록 페이지");
	}
	
	/* 예약 상세 페이지 이동 */
	@GetMapping({"/detail", "/modify"})
	public void resDetailPage(int rno, Model model) {
		
		logger.info("예약 상세 페이지");
		model.addAttribute("mrvo", resService.getDetail(rno));
	}
	
	/* 예약 등록 */
	@PostMapping("/regist")
	public String resRegist(ResVO rvo, MemVO mvo, RedirectAttributes rttr) {
		logger.info("MemVO : " + mvo);
		memService.regist(mvo);
		
		int mno = memService.getCurrMno();
		rvo.setMno(mno);
		logger.info("ResVO : " + rvo);
		resService.regist(rvo); // 등록
		
		rttr.addFlashAttribute("result", "regist success");
		return "redirect:/res/list";
	}
	
	/* 예약 가능여부 체크 */
	@ResponseBody
	@PostMapping("/checkDate")
	public String checkDate(@RequestParam("resdate") String resdate) {
		int result = resService.checkDate(resdate);
		return result > 0 ? "1" : "0";
	}
	
	/* 예약 취소 */
    @PostMapping("/delete")
	public String remove(@RequestParam("rno") int rno, RedirectAttributes rttr) {
		resService.delete(rno);
		rttr.addFlashAttribute("result", "delete success");
		return "redirect:/res/list";
	}
    
    /* 예약 변경 */
    @PostMapping("/modify")
	public String modify(MemResVO mrvo, RedirectAttributes rttr) {
    	
    	resService.modify(mrvo); // 예약 수정
    	memService.modify(mrvo); // 회원 수정
    	
    	rttr.addFlashAttribute("result", "modify success");
		return "redirect:/res/detail?rno=" + mrvo.getRno(); 
	}
}
