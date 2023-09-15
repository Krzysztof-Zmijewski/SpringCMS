package coderslab.app.home;

import coderslab.app.article.Article;
import coderslab.app.article.ArticleDao;
import coderslab.app.author.Author;
import coderslab.app.author.AuthorDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class HomePageController {
    ArticleDao articleDao;

    @GetMapping
    public String homePage(Model model){
        List<Article> articles = articleDao.findLatestFive();
        model.addAttribute("articles", articles);
        return "home-page-view";
    }

}
