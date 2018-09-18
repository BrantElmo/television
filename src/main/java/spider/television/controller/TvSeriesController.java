package spider.television.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import java.util.HashMap;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import spider.television.pojo.TvSeries;
import spider.television.service.TvSeriesService;

@RestController
@RequestMapping("/tvseries")
@Slf4j
public class TvSeriesController {

    @Autowired TvSeriesService TvSeriesService;

    /**
     * 获取全部电视剧信息
     * @return
     */
    @GetMapping
    public List<TvSeries> getAll() {
        if (log.isTraceEnabled()) {
            log.trace("getAll() used");
        }
        List<TvSeries> list = TvSeriesService.getAllTvSeries();
        if (log.isTraceEnabled()) {
            log.trace(list.size() + " data selected");
        }
        return list;
    }
    /**
     * 获取某一个电视剧信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public TvSeries getOne(@PathVariable int id) {
        if (log.isTraceEnabled()) {
            log.trace("getOne() used...");
        }
        if (id == 101) {
            return null;
        } else if (id == 102) {
            return null;
        } else {
            throw new ResourceNotFoundException();
        }
    }
    /**
     * 插入电视剧信息 
     * @param tvSeriesDto
     * @return
     */
    @PostMapping
    public TvSeries insertOne(@Validated @RequestBody TvSeries tvSeries, BindingResult result) {
        if (log.isTraceEnabled()) {
            log.trace("insertOne()");
        }
        if (result.hasErrors()) {
            return tvSeries;
        }
        tvSeries.setId(9999);
        
        return tvSeries;
    }

    /**
     * 更新一个电视剧信息
     * @param id
     * @param tvSeriesDto
     * @return
     */
    @PutMapping("/{id}")
    public TvSeries updateOne(@PathVariable int id, @RequestBody TvSeries tvSeriesDto) {
        if (log.isTraceEnabled()) {
            log.trace("updateOne:" + id);
        }
        if (id == 101 || id == 102) {
            return null;
        } else {
            throw new ResourceNotFoundException();
        }
    }
    /**
     * 删除一个电视剧信息
     * @param id
     * @param request
     * @param deleteReason
     * @return
     * @throws Exception
     */
    @DeleteMapping("/{id}")
    public Map<String, String> deleteOne(@PathVariable int id, HttpServletRequest request,
            @RequestParam(value="delete_reason", required=false) String deleteReason) throws Exception {
        
        if (log.isTraceEnabled()) log.trace("deleteOne:" + id);
        Map<String, String> result = new HashMap<>();
        if (id == 101) {
            result.put("message", "#101被" + request.getRemoteAddr() + "删除(原因:" + deleteReason + ")");
        } else if (id == 102) {
            throw new RuntimeException("#102不能被删除");
        } else {
            throw new ResourceNotFoundException();
        }
        return result;
    }

    /**
     * 添加一个照片
     * @param id
     * @param imgFile
     * @throws Exception
     */
    @PostMapping(value="/{id}/photos", consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
    public void addPhoto(@PathVariable int id, @RequestParam(value="photo") MultipartFile imgFile) throws Exception {
        if (log.isTraceEnabled()) {
            log.trace("id: " + id + "-> " + imgFile.getOriginalFilename());
        }

        FileOutputStream fos = new FileOutputStream("target/" + imgFile.getOriginalFilename());
        IOUtils.copy(imgFile.getInputStream(), fos);
        fos.close();
    }

    /**
     * 下载一个剧照
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping(value="/{id}/icon", produces=MediaType.IMAGE_JPEG_VALUE)
    public byte[] getIcon(@PathVariable int id ) throws Exception {
        if (log.isTraceEnabled()) {
            log.trace("getIcon:" + id);
        }

        String iconFile = "src/main/resources/img.jpg";
        InputStream is = new FileInputStream(iconFile);
        return IOUtils.toByteArray(is);
    }

}