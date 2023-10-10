package hotelspring.hotelproject.controller;

import hotelspring.hotelproject.dto.BoardDto;
import hotelspring.hotelproject.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {

    private BoardService boardService;

    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }
    // 공지 사항 - 페이징 처리
    @GetMapping("/board")
    public String list(Model model, @RequestParam(value = "page", defaultValue = "1") Integer pageNum) {
        List<BoardDto> boardDtoList = boardService.getBoardlist(pageNum);
        Integer[] pageList = boardService.getPageList(pageNum);

        model.addAttribute("boardList", boardDtoList);
        model.addAttribute("pageList", pageList);

        return "board/list";
    }

    @GetMapping("/post")
    public String write(){

        return "board/write";
    }

    @PostMapping("/post")
    public String wrtie(BoardDto boardDto) {
        boardService.savePost(boardDto);

        return "redirect:/board";
    }

    @GetMapping("/post/{no}")
    public String detail(@PathVariable("no") Long boardId, Model model) {
        BoardDto boardDto = boardService.getPost(boardId);
        model.addAttribute("boardDto", boardDto);

        return "board/detail";
    }

    // 수정 - 게시글의 데이터가 그대로 유지된 상태로 값을 바꿀 수 있는 화면으로 이동
    @GetMapping("/post/edit/{no}")
    public String edit(@PathVariable("no") Long boardId, Model model) {
        BoardDto boardDto = boardService.getPost(boardId);
        model.addAttribute("boardDto", boardDto);

        return "board/update";
    }

    // 수정 - 화면에서 값을 변경 후 DB에 새로운 데이터 저장
    @PutMapping("/post/edit/{no}")
    public String update(@PathVariable("no") Long boardId, BoardDto boardDto) {
//  public String update(BoardDto boardDto) {
//      boardService.savePost(boardDto);
        BoardDto getBoard = boardService.getPost(boardId);
        getBoard.setTitle(boardDto.getTitle());
        getBoard.setContent(boardDto.getContent());
        boardService.savePost(getBoard);

        return "redirect:/board";
    }

    // 삭제
    @DeleteMapping("/post/{no}")
    public String delete(@PathVariable("no") Long boardId) {
        boardService.deletePost(boardId);

        return "redirect:/board";
    }

    // 검색
    // @RequestParam 으로 요청으로 들어온 값 중 'keyword'로 넘어온 값을 받아서
    // 해당 키워드가 포함된 리스트를 넘겨주는 searchPosts를 사용하고
    // model을 통해 view에 값을 넘겨준다.
    @GetMapping("/board/search")
    public String search(@RequestParam(value = "keyword") String keyword, Model model) {
        List<BoardDto> boardDtoList = boardService.searchPosts(keyword);
        model.addAttribute("boardList", boardDtoList);

        return "board/list";
    }

}
