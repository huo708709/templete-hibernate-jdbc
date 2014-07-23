Ext.define('Westar.model.Menu', {
	extend: 'Ext.data.Model',
	fields: ['id', 'name', 'url', 'icon'],
	
	proxy: {
        type: 'ajax',
        url: 'data/recentsongs.json',
        reader: {
            type: 'json',
            root: 'results'
        }
    }
});