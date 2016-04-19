/// <reference path="../jquery-1.7.1/jquery-1.7.1.js" />
/// <reference path="kf/KFWidget.js" />


(function () {
    'use strict';
    Date.prototype.format = function (formatStr) {
        var str = formatStr;
        if (!formatStr) {
            str = "yyyy-MM-dd hh:mm:ss"; //默认格式
        }
        var Week = ['日', '一', '二', '三', '四', '五', '六'];
        str = str.replace(/yyyy|YYYY/, this.getFullYear());
        str = str.replace(/yy|YY/, (this.getYear() % 100) > 9 ? (this.getYear() % 100).toString() : '0' + (this.getYear() % 100));
        str = str.replace(/MM/, this.getMonth() >= 9 ? (parseInt(this.getMonth()) + 1).toString() : '0' + (parseInt(this.getMonth()) + 1));
        str = str.replace(/M/g, (parseInt(this.getMonth()) + 1));
        str = str.replace(/w|W/g, Week[this.getDay()]);
        str = str.replace(/dd|DD/, this.getDate() > 9 ? this.getDate().toString() : '0' + this.getDate());
        str = str.replace(/d|D/g, this.getDate());
        str = str.replace(/hh|HH/, this.getHours() > 9 ? this.getHours().toString() : '0' + this.getHours());
        str = str.replace(/h|H/g, this.getHours());
        str = str.replace(/mm/, this.getMinutes() > 9 ? this.getMinutes().toString() : '0' + this.getMinutes());
        str = str.replace(/m/g, this.getMinutes());

        str = str.replace(/ss|SS/, this.getSeconds() > 9 ? this.getSeconds().toString() : '0' + this.getSeconds());
        str = str.replace(/s|S/g, this.getSeconds());

        str = str.replace(/iii/g, this.getMilliseconds() < 10 ? '00' + this.getMilliseconds() : (this.getMilliseconds() < 100 ? '0' + this.getMilliseconds() : this.getMilliseconds()));

        return str;
    };
    Date.prototype.add = function (strInterval, Number) {
        var dtTmp = this;
        switch (strInterval) {
            case 's': return new Date(Date.parse(dtTmp) + (1000 * Number));
            case 'n': return new Date(Date.parse(dtTmp) + (60000 * Number));
            case 'h': return new Date(Date.parse(dtTmp) + (3600000 * Number));
            case 'd': return new Date(Date.parse(dtTmp) + (86400000 * Number));
            case 'w': return new Date(Date.parse(dtTmp) + ((86400000 * 7) * Number));
            case 'q': return new Date(dtTmp.getFullYear(), (dtTmp.getMonth()) + Number * 3, dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());
            case 'm': return new Date(dtTmp.getFullYear(), (dtTmp.getMonth()) + Number, dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());
            case 'y': return new Date((dtTmp.getFullYear() + Number), dtTmp.getMonth(), dtTmp.getDate(), dtTmp.getHours(), dtTmp.getMinutes(), dtTmp.getSeconds());
        }
    }
    Number.prototype.round = function (v) {
        var vv = Math.pow(10, v);
        var num = this;
        return (Math.round(num * vv) / vv);
    }
    String.prototype.format = function () {
        var args = arguments;/*, pattern = "{([0-" + args.length + "])}", re = new RegExp(pattern, "g");
        return this.replace(re,
            function ($1, $2) {
                return args[$2];
            }
        );*/
        var source = this;
        //debugger;
        for(var i = 0;i< args.length;i++){
        	var re = new RegExp('{('+i+')}','g');
        	source = source.replace(re, args[i]);
        }
        return source;
    };
    String.prototype.endsWith = function (a) {
        return this.substr(this.length - a.length) === a;
    };
    String.prototype.startsWith = function (a) {
        return this.substr(0, a.length) === a;
    };
    String.prototype.trim = function (c) {
        var reg = new RegExp('^[' + (c || ' ') + ']+|[' + (c || ' ') + ']+$', 'g');
        return this.replace(reg, '');
        //return this.replace(/^\s+|\s+$/g, "");
    };
    String.prototype.trimEnd = function (c) {
        var reg = new RegExp('[' + (c || ' ') + ']+$', 'g');
        return this.replace(reg, '');
        //return this.replace(/\s+$/, "");
    };
    String.prototype.trimStart = function (c) {
        var reg = new RegExp('^[' + (c || ' ') + ']+', 'g');
        return this.replace(reg, '');
        //return this.replace(/^\s+/, "");
    };

    Array.create = function (len, val) {
        var arr = new Array(len);
        for (var i = 0; i < len; i++) arr[i] = val;
        return arr;
    }
    Array.add = function (a, b) {
        a[a.length] = b;
    };
    Array.addRange = function (a, b) {
        a.push.apply(a, b);
    };
    Array.clear = function (a) {
        a.length = 0;
    };
    Array.clone = function (a) {
        if (a.length === 1) return [a[0]];
        else return Array.apply(null, a);
    };
    Array.contains = function (a, b) {
        return Array.indexOf(a, b) >= 0;
    };
    Array.indexOf = function (d, e, a) {
        if (typeof e === "undefined") return -1;
        var c = d.length;
        if (c !== 0) {
            a = a - 0;
            if (isNaN(a)) a = 0;
            else {
                if (isFinite(a)) a = a - a % 1;
                if (a < 0) a = Math.max(0, c + a)
            }
            for (var b = a; b < c; b++) if (typeof d[b] !== "undefined" && d[b] === e) return b;
        }
        return -1
    };
    Array.insert = function (a, b, c) {
        a.splice(b, 0, c);
    };
    Array.parse = function (value) {
        if (!value) return [];
        return eval(value);
    };
    Array.remove = function (b, c) {
        var a = Array.indexOf(b, c);
        if (a >= 0) b.splice(a, 1);
        return a >= 0;
    };
    Array.removeAt = function (a, b) {
        a.splice(b, 1);
    };
    Array.prototype.add = function (b) {
        Array.add(this, b);
    }
    Array.prototype.addRange = function (b) {
        this.push.apply(this, b);
    }
    Array.prototype.clone = function () {
        return Array.clone(this);
    }
    Array.prototype.contains = function (b) {
        return Array.contains(this, b);
    };
    Array.prototype.indexOf = function (e, a) {
        return Array.indexOf(this, e, a);
    };
    Array.prototype.insert = function (b, c) {
        Array.insert(this, b, c);
    };
    Array.prototype.parse = function (value) {
        return Array.parse(value);
    };
    Array.prototype.remove = function (c) {
        return Array.remove(this, c);
    };
    Array.prototype.removeAt = function (b) {
        return Array.removeAt(this, b);
    };
})();
(function (w) {
    'use strict';
    var _pageKey =Math.random().toString().substr(2) + new Date().valueOf();
    var isChildWin = function () {
        return top != w;
    }
    var getWin = function () {
        return isChildWin() ? top : w;
    }
    var registerNamespace = function (ns, type) {
        var d = w, c = ns.split(".");
        for (var b = 0; b < c.length; b++) {
            var e = c[b], a = d[e];
            if (!a) {
                a = d[e] = $.extend({}, b === c.length - 1 && type ? type : null);
            }
            d = a
        }
        return d;
    }
    var Application = function () {
        var _handlers = {},_notifications = {},_taskHandlers={},_contextPath;
        this.getContextPath = function(){
          return _contextPath;
        }
        this.setContextPath = function(contextPath){
          _contextPath = contextPath;
        }
        this.$regMessageHandler = function(pagekey,handler){
            _notifications[pagekey] = handler;
        }
        this.$removeMessageHandler = function(pagekey){
            delete _notifications[pagekey];
        }
        this.onMessage = function(handler){
            app.onNotify('reminding',handler);
        }
        this.onNotify = function(msgId,handler){
            msgId = msgId || 'reminding';
            if(isChildWin()) top.app.$regMessageHandler(_pageKey, app.notify);
            if(handler && $.isFunction(handler))
                var handlers = _handlers[msgId] || (_handlers[msgId]=[]);
                if(!handlers.contains(handler)) handlers.push(handler);
        }
        this.getHandlers = function(){return _handlers}
        this.getNotifications = function(){return _notifications;}
        this.notify = function(msgId,arg){
            msgId = msgId || '';
            var handlers = _handlers[msgId];
            if(handlers && handlers.length > 0){
	            $.each(handlers,function(i,handler){
	                setTimeout(function(){
	                    handler(arg);
	                },0);
	            });
            }
            var keys = Object.keys(_notifications);
            $.each(keys,function(i,key){
                if(_notifications[key]) setTimeout(function(){
                    _notifications[key](msgId,arg);
                },0);
            });
        }
        if(isChildWin()){
            $(window).unload(function(){
                top.app.$removeMessageHandler(_pageKey);
            });
        }
    }
    var CommonQueryBuilder = function () {
        //usage:
        //datagrid initial options:{parameters:{parameters:buildQuery()}}
        //post:{json_parameters:buildQuery()}
        function postFacadeServlet(queryType, queryFields, orderBy, pagingInfo, fieldCodeTypes, success,queryTypeClass) {
            var b;
            if($.isPlainObject(queryType)){
                if(!queryFields) queryFields = queryType['queryFields'];
                if(!orderBy) orderBy = queryType['orderBy'];
                if(!pagingInfo) pagingInfo = queryType['pagingInfo'];
                if(!fieldCodeTypes) fieldCodeTypes = queryType['fieldCodeTypes'];
                if(!success) success = queryType['success'];
                if(!queryTypeClass) queryTypeClass = queryType['queryTypeClass'];
            }
            success = success || ($.isFunction(fieldCodeTypes) ? (b = fieldCodeTypes, fieldCodeTypes = null, b) : null) ||
                           ($.isFunction(pagingInfo) ? (b = pagingInfo, pagingInfo = null, b) : null) ||
                           ($.isFunction(orderBy) ? (b = orderBy, orderBy = null, b) : null) ||
                           ($.isFunction(queryFields) ? (b = queryFields, queryFields = null, b) : null) || success;
            var parameters = buildQuery(queryType, queryFields, orderBy, pagingInfo, fieldCodeTypes);
            return $.ajax({
                type: "POST",
                url: queryConfig.facade,
                dataType: "json",
                data: { json_parameters: JSON.stringify(parameters) },
                success: success
            });
        }
        function getSelectCodeData(codeType, success) {
            //var codeDef;
            //if (!(typeof (SELECT_CODE_DEFINITIONS) != 'undefined' && (codeDef = SELECT_CODE_DEFINITIONS[codeType]))) return;
            var queryInfo = {
                queryType: codeType//,
                //
                //queryFields: codeDef.queryFields
            };

            var parameters = {
                serviceName: "commonQueryService",
                methodName: "getSelectCodeData",
                parameters: { queryInfo: queryInfo }
            };
            $.ajax({
                type: "POST",
                url: queryConfig.facade,
                dataType: "json",
                data: { json_parameters: JSON.stringify(parameters) },
                success: success
            });
        }
        function buildQuery(queryType, queryFields, orderBy, pagingInfo, fieldCodeTypes, queryTypeClass,methodName) {
            if($.isPlainObject(queryType)){
                if(!queryFields) queryFields = queryType['queryFields'];
                if(!orderBy) orderBy = queryType['orderBy'];
                if(!pagingInfo) pagingInfo = queryType['pagingInfo'];
                if(!fieldCodeTypes) fieldCodeTypes = queryType['fieldCodeTypes'];
                if(!queryTypeClass) queryTypeClass = queryType['queryTypeClass'];
                if(!methodName) methodName = queryType['methodName'];
            }
            if ($.isPlainObject(queryFields)) queryFields = buildQueryFields(queryFields);
            var parameters = {
                serviceName: "commonQueryService",
                methodName: methodName || "query",
                parameters: {
                    queryInfo: {
                        queryType: queryType,
                        orderBy: orderBy,
                        fieldCodeTypes: fieldCodeTypes,
                        queryFields: queryFields,
                        pagingInfo: pagingInfo
                    }
                }
            };
            if (queryTypeClass) parameters.parameters.queryInfo['queryTypeClass'] = queryTypeClass;
            return parameters;
        }
        function buildPagingInfo(currentPage, pageSize) {
            return {
                pageSize: pageSize,
                currentPage: currentPage
            };
        }
        function buildQueryFields(parameters) {
            var queryFields = [], fieldType, operator;
            $.each(parameters, function (fieldName, fieldValue) {
                fieldType = null, operator = '=';
                if ($.isPlainObject(fieldValue)) {
                    if (fieldValue['fieldName'] && fieldValue['fieldStringValue']) {
                        queryFields.push(fieldValue);
                        return;
                    } else {
                        fieldType = fieldValue['fieldType'];
                        operator = fieldValue['operator'];
                        fieldValue = fieldValue['fieldValue'];
                    }
                }
                queryFields.push(buildQueryField(fieldName, fieldValue, fieldType, operator));
            });
            return queryFields;
        }
        function buildQueryField(fieldName, fieldValue, fieldType, operator) {
            if (!fieldType && !isNaN(fieldValue)) {
                if ($.isPlainObject(fieldValue)) fieldValue = JSON.stringify(fieldValue);
                else if ($.isArray(fieldValue)) { fieldType = 'String[]'; fieldValue = fieldValue.join(',') }
                else if (typeof (fieldValue) == 'object' && !$.isNumeric(fieldValue) && isNaN(new Date(fieldValue))) fieldType = 'Date';
            }
            var queryField = { fieldName: fieldName, fieldType: fieldType, fieldStringValue: fieldValue, operator: operator || '=' };
            if ($.isFunction(fieldValue)) return app.util.attachToJSONDelegate(queryField, true);
            return queryField;
        }
        this.postFacadeServlet = postFacadeServlet;
        this.buildQuery = buildQuery;
        this.buildPagingInfo = buildPagingInfo;
        this.buildQueryFields = buildQueryFields;
        this.buildQueryField = buildQueryField;
        this.getSelectCodeData = getSelectCodeData;
    }
    var Util = function () {
        var urlargs;
        function createDelegate() {
            if (arguments.length === 0) return function () { }
            var args = Array.clone(arguments);
            var block = args.pop();
            if (typeof (block) !== 'string') return function () { return block }
            return new Function(args, block);
        }

        this.getParam = function (name) {
            if(!urlargs){
                urlargs= {};
                var params=document.location.search,reg=/(?:^\?|&)(.*?)=(.*?)(?=&|$)/g,temp;
                while((temp=reg.exec(params))!=null) urlargs[temp[1]]=decodeURIComponent(temp[2]);
            }
            return urlargs[name];
        }
        this.setMenuItemTextByQuery = function(queryInfo){
        	if($.isArray(queryInfo)){
        		CommonQueryRowCountManager.getRowCounts(queryInfo,function(result){
        			if(result && result.length > 0){
        				$.each(queryInfo,function(i,qi){
        					app.util.setMenuItemText(qi['menuCode'],result[i] || 0);
        				});
        			}
        		});
        	}else{
        		CommonQueryRowCountManager.getRowCount(queryInfo,function(result){
        		  app.util.setMenuItemText(queryInfo['menuCode'],result || 0);
        		});        		
        	}
        }
        function getMenuItem(code){
        	return getWin().$("#ctMainMenu #menuItem_"+code);
        }
        this.getMenuItem = getMenuItem;
        this.setMenuItemText=function(code,txt){
          if(isChildWin()) return top.app.util.setMenuItemText(code,txt);
        	var menuItem = getMenuItem(code);
        	if(!code || menuItem.length == 0) return;
        	var el = menuItem.find("span");
        	if(el.length == 0 ) el = $("<span style='color:red'></span>").appendTo(menuItem);
        	if($.isPlainObject(txt)){
        		var data = el.data("TagText") || {};
        		data = $.extend(data,txt);
        		txt = 0;
        		$.each(data,function(k,v){txt += (parseInt(v) || 0);});
        		el.data("TagText",data);
        	}
        	txt = "(" + (txt || 0) + ")";
        	el.text(txt);
        }
        this.addTabs = function (title, url, newTab, closable, ctTab) {
            var index;
            url = (url || title || '').trim();
            if (url && (index = url.indexOf('javascript:')) >= 0) {
                var last = url.indexOf('?menuGroupUuid');
                url = url.substr(index, (last == -1 ? url.length : last) - index);
                return createDelegate(url)();
            }
            if (url.charAt(0) == '/' && app.getContextPath() && !url.startsWith(app.getContextPath()))
                url = app.getContextPath() + url;
            ctTab = ctTab || 'centerTabs';
            var win = getWin(), tabs = win.$("#" + ctTab);
            if (tabs.length == 0) {
                win.open(url, '_blank');
                return;
            }
            var tab = tabs.tabs("getTab", title);
            var tabCount = tabs.tabs('tabs').length; //统计打开窗口个数(不包含首页)
            if (title == "首页") {
                tabs.tabs("add", {
                    title: title,
                    iconCls: "icon_home",
                    closable: closable,
                    fit: true,
                    width: tabs.parent().width(),
                    height: "auto",
                    content: "<iframe scrolling='no' frameborder='0' style='width:100%;height:100%' marginwidth='0px' marginheight='0px' src='" + url + "'></iframe>"
                });
            } else if (tab) {
                if (newTab) {
                    tabs.tabs("close", title);
                    tabs.tabs("add", {
                        title: title,
                        closable: closable,
                        fit: true,
                        width: tabs.parent().width(),
                        height: "auto",
                        content: "<iframe scrolling='no' frameborder='0' style='width:100%;height:100%' marginwidth='0px' marginheight='0px' src='" + url + "'></iframe>"
                    });
                } else {
                    tabs.tabs("select", title);
                }
            } else {
                if (tabCount <= 8) {
                    tabs.tabs("add", {
                        title: title,
                        closable: closable,
                        fit: true,
                        width: tabs.parent().width(),
                        height: "auto",
                        content: "<iframe scrolling='no' frameborder='0' style='width:100%;height:100%' marginwidth='0px' marginheight='0px' src='" + url + "'></iframe>"
                    });
                } else {
                    alert("您打开窗口太多，请关闭没用窗口!");
                }
            }
            $(tabs.tabs("getSelected").find("iframe")[0].contentWindow.document).find("input:visible:first").focus();
        }
        function attachToJSONDelegate(obj, noSkip) {
            if ($.isPlainObject(obj) || $.isArray(obj)) {
                obj['toJSON'] = function () {
                    var o = {};
                    $.each(obj, function (k, v) {
                        if (k != 'toJSON') {
                            v = $.isFunction(v) ? v() : v;
                            if (v || !v && noSkip) o[k] = v;
                        }
                    });
                    return o;
                    //return $.toJSON(o);
                }
            }
            return obj;
        }
        function getFormData(form){
          var $form = $(form[0]);
          var formValues = {};
          $form.find("input[name][class!='combo-value']").each(function () {
            var $input = $(this);
            var name = $input.attr("name");
            if ($input.attr("type") == "checkbox") {
                formValues[name] = function () {
                    var values = [];
                    $form.find("input[name='" + name + "']:checked").each(function () {
                        values.push($(this).attr("on") || $(this).attr("value"));
                    });
                    return values.join(',');
                }();
            } else if ($input.attr("type") == "radio") {
                formValues[name] = function () {
                    return $form.find("input[name='" + name + "']:checked").attr("value");
                }();
            } else if ($input.hasClass("easyui-numberbox")) {
                formValues[name] = function () { return $input.numberbox("getValue"); }();
            } else {
                formValues[name] = function () { return $input.val(); }();
            }
          });
          $form.find("input[comboname],select[comboname]").each(function () {
              var $input = $(this), name = $input.attr("comboname");
              if ($input.hasClass('combo-multi')) {
                  formValues[name] = function () {
                      if ($input.data('combo')) {
                          var values = $input.combo("getComboMultiValues");
                          return values.join(',');
                      } else return '';
                  }();
              } else {
                  formValues[name] = function () {
                      return $input.data('combo') ? $input.combo('getValue') : '';
                  }();
              }
          });   
          return formValues;
        }
        function createFormValuesDelegate(form, addJSONDelegate) {
            var $form = $(form[0]);
            var formValues = {};
            $form.find("input[name][class!='combo-value']").each(function () {
                var $input = $(this);
                var name = $input.attr("name");
                if ($input.attr("type") == "checkbox") {
                    formValues[name] = function () {
                        var values = [];
                        $form.find("input[name='" + name + "']:checked").each(function () {
                            values.push($(this).attr("on") || $(this).attr("value"));
                        });
                        return values.join(',');
                    }
                } else if ($input.attr("type") == "radio") {
                    formValues[name] = function () {
                        return $form.find("input[name='" + name + "']:checked").attr("value");
                    }
                } else if ($input.hasClass("easyui-numberbox")) {
                    formValues[name] = function () { return $input.numberbox("getValue"); }
                } else {
                    formValues[name] = function () { return $input.val(); }
                }
            });
            $form.find("input[comboname]").each(function () {
                var $input = $(this), name = $input.attr("comboname");
                if ($input.hasClass('combo-multi')) {
                    formValues[name] = function () {
                        if ($input.data('combo')) {
                            var values = $input.combo("getComboMultiValues");
                            return values.join(',');
                        } else return '';
                    }
                } else {
                    formValues[name] = function () {
                        return $input.data('combo') ? $input.combo('getValue') : '';
                    }
                }
            });
            return addJSONDelegate ? attachToJSONDelegate(formValues) : formValues;
        };
        this.getUrlParam = function(url,name) {
            var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
            var search;
            var num = url.indexOf("?");
            if(num > -1) {
            	search = url.substr(num + 1);
            } else {
            	search = url;
            }
            var r = search.match(reg);  //匹配目标参数
            if (r != null) return decodeURI(r[2]); return null; //返回参数值
        }
        this.attachToJSONDelegate = attachToJSONDelegate;
        this.createFormValuesDelegate = createFormValuesDelegate;
        this.getWin = getWin;
        this.getFormData = getFormData;
        this.createDelegate = createDelegate;
        this.registerNamespace = registerNamespace;
    }
    registerNamespace("app", new Application());
    registerNamespace("app.util", new Util());
    registerNamespace("app.commonQuery", new CommonQueryBuilder());
})(window);