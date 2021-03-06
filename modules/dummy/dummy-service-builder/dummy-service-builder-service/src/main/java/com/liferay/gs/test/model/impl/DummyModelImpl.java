/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.gs.test.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.gs.test.model.Dummy;
import com.liferay.gs.test.model.DummyModel;
import com.liferay.gs.test.model.DummySoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Dummy service. Represents a row in the &quot;TEST_Dummy&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link DummyModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DummyImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DummyImpl
 * @see Dummy
 * @see DummyModel
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class DummyModelImpl extends BaseModelImpl<Dummy> implements DummyModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a dummy model instance should use the {@link Dummy} interface instead.
	 */
	public static final String TABLE_NAME = "TEST_Dummy";
	public static final Object[][] TABLE_COLUMNS = {
			{ "mvccVersion", Types.BIGINT },
			{ "uuid_", Types.VARCHAR },
			{ "dummyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "field1", Types.VARCHAR },
			{ "field2", Types.BOOLEAN },
			{ "field3", Types.INTEGER },
			{ "field4", Types.TIMESTAMP },
			{ "field5", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("mvccVersion", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("dummyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("field1", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("field2", Types.BOOLEAN);
		TABLE_COLUMNS_MAP.put("field3", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("field4", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("field5", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table TEST_Dummy (mvccVersion LONG default 0 not null,uuid_ VARCHAR(75) null,dummyId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,field1 VARCHAR(75) null,field2 BOOLEAN,field3 INTEGER,field4 DATE null,field5 VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table TEST_Dummy";
	public static final String ORDER_BY_JPQL = " ORDER BY dummy.field1 ASC";
	public static final String ORDER_BY_SQL = " ORDER BY TEST_Dummy.field1 ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.gs.test.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.gs.test.model.Dummy"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.gs.test.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.gs.test.model.Dummy"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.gs.test.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.gs.test.model.Dummy"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long FIELD1_COLUMN_BITMASK = 2L;
	public static final long FIELD2_COLUMN_BITMASK = 4L;
	public static final long GROUPID_COLUMN_BITMASK = 8L;
	public static final long UUID_COLUMN_BITMASK = 16L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Dummy toModel(DummySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Dummy model = new DummyImpl();

		model.setMvccVersion(soapModel.getMvccVersion());
		model.setUuid(soapModel.getUuid());
		model.setDummyId(soapModel.getDummyId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setField1(soapModel.getField1());
		model.setField2(soapModel.getField2());
		model.setField3(soapModel.getField3());
		model.setField4(soapModel.getField4());
		model.setField5(soapModel.getField5());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Dummy> toModels(DummySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Dummy> models = new ArrayList<Dummy>(soapModels.length);

		for (DummySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.gs.test.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.gs.test.model.Dummy"));

	public DummyModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _dummyId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setDummyId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _dummyId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Dummy.class;
	}

	@Override
	public String getModelClassName() {
		return Dummy.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mvccVersion", getMvccVersion());
		attributes.put("uuid", getUuid());
		attributes.put("dummyId", getDummyId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("field1", getField1());
		attributes.put("field2", getField2());
		attributes.put("field3", getField3());
		attributes.put("field4", getField4());
		attributes.put("field5", getField5());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mvccVersion = (Long)attributes.get("mvccVersion");

		if (mvccVersion != null) {
			setMvccVersion(mvccVersion);
		}

		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long dummyId = (Long)attributes.get("dummyId");

		if (dummyId != null) {
			setDummyId(dummyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String field1 = (String)attributes.get("field1");

		if (field1 != null) {
			setField1(field1);
		}

		Boolean field2 = (Boolean)attributes.get("field2");

		if (field2 != null) {
			setField2(field2);
		}

		Integer field3 = (Integer)attributes.get("field3");

		if (field3 != null) {
			setField3(field3);
		}

		Date field4 = (Date)attributes.get("field4");

		if (field4 != null) {
			setField4(field4);
		}

		String field5 = (String)attributes.get("field5");

		if (field5 != null) {
			setField5(field5);
		}
	}

	@JSON
	@Override
	public long getMvccVersion() {
		return _mvccVersion;
	}

	@Override
	public void setMvccVersion(long mvccVersion) {
		_mvccVersion = mvccVersion;
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getDummyId() {
		return _dummyId;
	}

	@Override
	public void setDummyId(long dummyId) {
		_dummyId = dummyId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getField1() {
		if (_field1 == null) {
			return StringPool.BLANK;
		}
		else {
			return _field1;
		}
	}

	@Override
	public void setField1(String field1) {
		_columnBitmask = -1L;

		if (_originalField1 == null) {
			_originalField1 = _field1;
		}

		_field1 = field1;
	}

	public String getOriginalField1() {
		return GetterUtil.getString(_originalField1);
	}

	@JSON
	@Override
	public boolean getField2() {
		return _field2;
	}

	@JSON
	@Override
	public boolean isField2() {
		return _field2;
	}

	@Override
	public void setField2(boolean field2) {
		_columnBitmask |= FIELD2_COLUMN_BITMASK;

		if (!_setOriginalField2) {
			_setOriginalField2 = true;

			_originalField2 = _field2;
		}

		_field2 = field2;
	}

	public boolean getOriginalField2() {
		return _originalField2;
	}

	@JSON
	@Override
	public int getField3() {
		return _field3;
	}

	@Override
	public void setField3(int field3) {
		_field3 = field3;
	}

	@JSON
	@Override
	public Date getField4() {
		return _field4;
	}

	@Override
	public void setField4(Date field4) {
		_field4 = field4;
	}

	@JSON
	@Override
	public String getField5() {
		if (_field5 == null) {
			return StringPool.BLANK;
		}
		else {
			return _field5;
		}
	}

	@Override
	public void setField5(String field5) {
		_field5 = field5;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Dummy.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Dummy.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Dummy toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Dummy)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		DummyImpl dummyImpl = new DummyImpl();

		dummyImpl.setMvccVersion(getMvccVersion());
		dummyImpl.setUuid(getUuid());
		dummyImpl.setDummyId(getDummyId());
		dummyImpl.setGroupId(getGroupId());
		dummyImpl.setCompanyId(getCompanyId());
		dummyImpl.setUserId(getUserId());
		dummyImpl.setUserName(getUserName());
		dummyImpl.setCreateDate(getCreateDate());
		dummyImpl.setModifiedDate(getModifiedDate());
		dummyImpl.setField1(getField1());
		dummyImpl.setField2(getField2());
		dummyImpl.setField3(getField3());
		dummyImpl.setField4(getField4());
		dummyImpl.setField5(getField5());

		dummyImpl.resetOriginalValues();

		return dummyImpl;
	}

	@Override
	public int compareTo(Dummy dummy) {
		int value = 0;

		value = getField1().compareTo(dummy.getField1());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Dummy)) {
			return false;
		}

		Dummy dummy = (Dummy)obj;

		long primaryKey = dummy.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		DummyModelImpl dummyModelImpl = this;

		dummyModelImpl._originalUuid = dummyModelImpl._uuid;

		dummyModelImpl._originalGroupId = dummyModelImpl._groupId;

		dummyModelImpl._setOriginalGroupId = false;

		dummyModelImpl._originalCompanyId = dummyModelImpl._companyId;

		dummyModelImpl._setOriginalCompanyId = false;

		dummyModelImpl._setModifiedDate = false;

		dummyModelImpl._originalField1 = dummyModelImpl._field1;

		dummyModelImpl._originalField2 = dummyModelImpl._field2;

		dummyModelImpl._setOriginalField2 = false;

		dummyModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Dummy> toCacheModel() {
		DummyCacheModel dummyCacheModel = new DummyCacheModel();

		dummyCacheModel.mvccVersion = getMvccVersion();

		dummyCacheModel.uuid = getUuid();

		String uuid = dummyCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			dummyCacheModel.uuid = null;
		}

		dummyCacheModel.dummyId = getDummyId();

		dummyCacheModel.groupId = getGroupId();

		dummyCacheModel.companyId = getCompanyId();

		dummyCacheModel.userId = getUserId();

		dummyCacheModel.userName = getUserName();

		String userName = dummyCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			dummyCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			dummyCacheModel.createDate = createDate.getTime();
		}
		else {
			dummyCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			dummyCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			dummyCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		dummyCacheModel.field1 = getField1();

		String field1 = dummyCacheModel.field1;

		if ((field1 != null) && (field1.length() == 0)) {
			dummyCacheModel.field1 = null;
		}

		dummyCacheModel.field2 = getField2();

		dummyCacheModel.field3 = getField3();

		Date field4 = getField4();

		if (field4 != null) {
			dummyCacheModel.field4 = field4.getTime();
		}
		else {
			dummyCacheModel.field4 = Long.MIN_VALUE;
		}

		dummyCacheModel.field5 = getField5();

		String field5 = dummyCacheModel.field5;

		if ((field5 != null) && (field5.length() == 0)) {
			dummyCacheModel.field5 = null;
		}

		return dummyCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{mvccVersion=");
		sb.append(getMvccVersion());
		sb.append(", uuid=");
		sb.append(getUuid());
		sb.append(", dummyId=");
		sb.append(getDummyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", field1=");
		sb.append(getField1());
		sb.append(", field2=");
		sb.append(getField2());
		sb.append(", field3=");
		sb.append(getField3());
		sb.append(", field4=");
		sb.append(getField4());
		sb.append(", field5=");
		sb.append(getField5());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.liferay.gs.test.model.Dummy");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>mvccVersion</column-name><column-value><![CDATA[");
		sb.append(getMvccVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dummyId</column-name><column-value><![CDATA[");
		sb.append(getDummyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>field1</column-name><column-value><![CDATA[");
		sb.append(getField1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>field2</column-name><column-value><![CDATA[");
		sb.append(getField2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>field3</column-name><column-value><![CDATA[");
		sb.append(getField3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>field4</column-name><column-value><![CDATA[");
		sb.append(getField4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>field5</column-name><column-value><![CDATA[");
		sb.append(getField5());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Dummy.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Dummy.class
		};
	private long _mvccVersion;
	private String _uuid;
	private String _originalUuid;
	private long _dummyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _field1;
	private String _originalField1;
	private boolean _field2;
	private boolean _originalField2;
	private boolean _setOriginalField2;
	private int _field3;
	private Date _field4;
	private String _field5;
	private long _columnBitmask;
	private Dummy _escapedModel;
}