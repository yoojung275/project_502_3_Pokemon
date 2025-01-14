package org.choongang.mypage.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.PostMapping;
import org.choongang.global.config.annotations.RequestMapping;
import org.choongang.mypage.services.ProfileService;
import org.choongang.pokemon.entities.PokemonDetail;
import org.choongang.pokemon.services.MyPokemonService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/mypage")
public class MypageController {

    private final ProfileService profileService;
    private final MyPokemonService pokemonService;
    private final HttpServletRequest request;

    /**
     * 마이페이지 메인
     *
     * @return
     */
    @GetMapping
    public String index() {
        request.setAttribute("addCss", new String[] {"mypage/mypageStyle"});
        request.setAttribute("addScript", List.of("mypage/profile"));

        return "mypage/index";
    }

    /**
     * 회원 정보 확인 및 수정
     *
     * @return
     */
    @GetMapping("/info")
    public String info() {
        List<PokemonDetail> items = pokemonService.getList();

        request.setAttribute("addScript", List.of("mypage/profile","mypage/info"));
        request.setAttribute("addCss", new String[] {"mypage/profileUpdateStyle"});
        request.setAttribute("items", items);


        request.setAttribute("items", items);
        return "mypage/info";
    }

    /**
     * 회원 정보 확인 및 수정
     * @return
     */
    @PostMapping("/info")
    public String infoPs(RequestProfile form) {

        profileService.update(form);

        String url = request.getContextPath() + "/mypage";
        String script = String.format("parent.location.replace('%s');", url);

        request.setAttribute("script", script);


        profileService.update(form);

        String url = request.getContextPath() + "/mypage";
        String script = String.format("parent.location.replace('%s');", url);
        request.setAttribute("script", script);
        return "commons/execute_script";
    }

    @GetMapping("/alert")
    public String alert() {

        request.setAttribute("addCss", new String[] {"mypage/alertStyle"});

        return "mypage/alert";
    }
}