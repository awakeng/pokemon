package poketmon.controller;

import poketmon.model.PoketmonModelMethod;

public class PoketmonController {
	private static PoketmonController instance = new PoketmonController();
	private PoketmonModelMethod method = PoketmonModelMethod.getInstance(); 
	
	private PoketmonController() {}
	public static PoketmonController getInstance() {
		return instance;
	}
	
	// 모든 프로젝트 검색
	
	// 특정 프로젝트 검색
	
	// 새로운 프로젝트 저장
	
	// 존재하는 프로젝트 수정
	
	// 모든 프로젝트 삭제
}
