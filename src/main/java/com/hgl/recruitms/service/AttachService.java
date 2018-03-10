package com.hgl.recruitms.service;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hgl.recruitms.model.Attach;

/**
 * ClassName: AttachService <br/>
 * Description：附件相关
 * 
 * @author huanggl
 * @version Copyright (c) 2018, 黄光亮毕业设计----All Rights Reserved.
 */
public interface AttachService {

	/**  
	 * getAttachRealPath:根据配置附件配置信息，获取文件存储绝对路径. <br/>  
	 * @author huanggl
	 * @param conf  
	 */
	String getAttachRealPath();
	/**
	 * uploadAttach:(上传附件). <br/>
	 * 
	 * @author huanggl
	 * @param is
	 *            文件输入流
	 * @param fileName
	 *            文件名
	 * @param nAttachNoOld
	 *            附件旧ID
	 * @param sCreator
	 *            上传者
	 * @param sCreatorNo
	 *            上传者ID
	 * @return
	 * @throws IOException
	 */
	Attach uploadAttach(InputStream is, String fileName,String sAttachType,Integer nAttachNoOld, String sCreator,
			String sCreatorNo) throws IOException;

	/**
	 * checkFileName:(校验文件名称). <br/>
	 * 
	 * @author huanggl
	 * @param fileName
	 * @return
	 */
	boolean checkFileName(String fileName);

	/**
	 * downloadAttach：通过附件id下载附件
	 * 
	 * @author huanggl
	 * @createDate 2017年12月18日
	 * @param nAttachNo
	 *            附件ID
	 * @return
	 * @throws IOException
	 */
	void downloadAttach(Attach attachDto, OutputStream os) throws IOException;

	/**
	 * getAttach:(获取附件信息). <br/>
	 * 
	 * @author huanggl
	 * @param nAttachNo
	 *            附件id
	 * @return
	 */
	Attach getAttach(Integer nAttachNo);

	/**
	 * zipPackDownload：批量下载
	 * 
	 * @author huanggl
	 * @createDate 2017年12月21日
	 * @param attachNoList
	 * @param os
	 * @return
	 * @throws IOException
	 */
	void zipPack(List<Attach> nAttachNoList, OutputStream os) throws IOException;

	/**
	 * getAttachVersions:(根据附件ID查询历史版本附件). <br/>
	 * 
	 * @author huanggl
	 * @param nAttachNo
	 *            附件ID
	 * @return
	 */
	List<Attach> getAttachVersions(Integer nAttachNo);

	/**
	 * deleteAttach:(删除附件). <br/>
	 * 
	 * @author huanggl
	 * @param nAttachNo
	 *            附加ID
	 * @return
	 */
	boolean deleteAttach(Integer nAttachNo);

	/**
	 * getAttachList:根据附件ID列表查询附件信息. <br/>
	 * 
	 * @author huanggl
	 * @param attachNoList
	 * @return
	 */
	List<Attach> getAttachList(List<Integer> attachNoList);

	/**
	 * getAttachListPage:(根据产品类型和列表搜索条件查询分页信息). <br/>
	 * 
	 * @author huanggl
	 * @param pageIndex
	 * @param pageSize
	 * @param sAttachName 附件名称
	 * @param sFileType 文件类型
	 * @param dCreateTime 创建时间
	 * @return
	 */
	PageInfo<Attach> getAttachListPage(int pageIndex, int pageSize, String sAttachName, String sFileType,String sAttachType);

	/**
	 * updateAttachFileName:修改附件名称. <br/>
	 * 
	 * @author huanggl
	 * @param nAttachNo
	 *            附件ID
	 * @param attachName
	 *            修改后的文件名
	 * @return
	 */
	boolean updateAttachName(Integer nAttachNo, String attachName);

}
