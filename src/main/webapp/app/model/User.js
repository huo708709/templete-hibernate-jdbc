Ext.define('Westar.model.User', {
	extend: 'Ext.data.Model',
	fields: ['id', 'name', 'sex', 'age'],
	
	proxy: {
        type: 'ajax',
        url: 'data/recentsongs.json',
        reader: {
            type: 'json',
            root: 'results'
        }
    }
});